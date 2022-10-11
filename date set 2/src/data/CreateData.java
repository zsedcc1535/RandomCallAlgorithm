package data;

import pojo.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

//数据集生成器
public class CreateData {
    //public static void main(String[] args) throws IOException, ClassNotFoundException {
    public  void Create() throws IOException, ClassNotFoundException {
        for (int filename = 1;filename<6;filename++) {
            RandInfo rand = new RandInfo();
            RandAttendance randAttendance = new RandAttendance();
            File file = new File(".\\class"+filename+".txt"); // 建立文件
            ArrayList<Student> students = new ArrayList<Student>();
            if (!file.exists()) file.createNewFile();
            HashSet<Integer> attendance = new HashSet<Integer>();
            attendance = randAttendance.Rand1();//生成80%课程没来的学生序号（升序排序后的）
            int size01 = 0;
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for (int i = 0; i < 90; i++) {
                    Student person = new Student();
                    String familyName = rand.getFamilyName();
                    String[] nameAndSex = rand.getNameAndSex(rand.getSex());
                    String name = nameAndSex[0];
                    String sex = nameAndSex[1];
                    double grade = rand.getGrade();

                    person.setName(familyName.concat(name));
                    person.setSex(sex);
                    person.setGrade(grade);
//                int[] courses = new int[20];
//                if(attendance.contains(i)){
//                    courses = randAttendance.Rand2();
//                }
//                person.setAttendance(courses);
                    //  System.out.println(person);
                    students.add(person);
                }
                //按照绩点升序排序
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.getGrade() >= o2.getGrade()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });

                for (int i = 0; i < 90; i++) {
                    //修改80%课程没来的人的attendance数组
                    int[] courses = new int[20];
                    if (attendance.contains(i)) {
                        courses = randAttendance.Rand2();
                    }
                    Student student = students.get(i);
                    student.setAttendance(courses);
                    //设置抽点的概率
                    int probability = 0;
                    //     probability = 100 - new Random().nextInt(i);
                    if (i < 15) probability = 100;
//                    else if (i < 20) probability = 100 - 2 * i;
//                    else probability = (i - 100) * (i - 100) / 200;
                    //          if (i > 60) probability /= 2;
                    student.setProbability(probability);
                    students.set(i, student);
                }
                //每节课缺勤的同学0~3位
                students = randAttendance.Rand3(students, attendance);

                for (Student oneUser : students) {
                    System.out.println(oneUser);
                }
                oos.writeObject(students);
                System.out.println("文件已存入");
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        System.out.println(students.size()) ;
//        for(Student oneUser:students)
//        {
//            System.out.println(oneUser);
//        }

        }
    }
}
