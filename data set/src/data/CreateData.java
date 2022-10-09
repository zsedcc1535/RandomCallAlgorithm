package data;

import pojo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

//数据集生成器
public class CreateData {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
  // public  void Create(String[] args) throws IOException, ClassNotFoundException {
        RandInfo rand = new RandInfo();
        RandAttendance randAttendance = new RandAttendance();
        File file = new File(".\\test.dat") ; // 建立文件
        ArrayList<Student> students = new ArrayList<Student>();
        if (!file.exists()) file.createNewFile() ;
        file = new File(".\\test.dat") ;
        HashSet<Integer> attendance = new HashSet<Integer>();
        attendance = randAttendance.Rand1();
        int size01 = 0;
        try{
            FileOutputStream fos = new FileOutputStream(file) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            for (int i = 0 ; i<90 ;i++) {
                Student person = new Student();
                String familyName = rand.getFamilyName();
                String[] nameAndSex = rand.getNameAndSex(rand.getSex());
                String name = nameAndSex[0];
                String sex = nameAndSex[1];
                double grade = rand.getGrade();

                person.setName(familyName.concat(name));
                person.setSex(sex);
                person.setGrade(grade);
                size01 = students.size();
                int[] courses = new int[20];
                if(attendance.contains(size01)){
                    courses = randAttendance.Rand2();
                }
                person.setAttendance(courses);
              //  System.out.println(person);
                students.add(person);
            }

            students =randAttendance.Rand3(students,attendance);
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if(o1.getGrade() >= o2.getGrade()) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            });

            for(Student oneUser:students)
            {
                System.out.println(oneUser);
            }
            oos.writeObject(students);
            System.out.println("文件已存入");
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
//        System.out.println(students.size()) ;
//        for(Student oneUser:students)
//        {
//            System.out.println(oneUser);
//        }

    }
}
