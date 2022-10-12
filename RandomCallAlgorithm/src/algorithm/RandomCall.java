package algorithm;

import data.CreateData;
import pojo.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomCall {
    public static void main(String[] args) {
        float avg = 0;
        float[] ans = new float[5];
        float d = 0;
        CreateData createData = new CreateData();
        try {
            createData.Create();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int filename = 1; filename < 6; filename++) {
            float x1 = 0;//有效点名次数
            float x2 = 0;//总点名次数
            GetData getData = new GetData();
            ArrayList<Student> students = new ArrayList<>(); //学生数据集
            try {
                students = getData.GetRandData(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int[][] ints = new int[90][20];
            //得到点名数据表ints
            for (int i = 0; i < 90; i++) {
                Student student = new Student();
                student = students.get(i);
                ints[i] = student.getAttendance();
            }
            int[][] ints_end = new int[90][20];
            int number = 15;
            for (int j = 0; j < 20; j++) {
                Student student = new Student();
                int probability = 0;
                int absenteeism = 0;
                for (int i = 0; i < 90; i++) {
                    student = students.get(i);
                    probability = student.getProbability();//点名概率
                    absenteeism = student.getAbsenteeism();//缺点次数
                    if(ints[i][j] == 1 && probability ==100) ;
                    else if (j + 1 - absenteeism > 2) {
                        if (number > 8) {
                            number--;
                            probability = 0;
                        }
                        else if(j + 1 - absenteeism > 3&&number >5){
                            number--;
                            probability = 0;
                        }
                        else if (j + 1 - absenteeism > 4) {
                            number--;
                            probability = 0;
                        }
                    }
                    int num = new Random().nextInt(100) + 1;
                    //点到了
                    if (num < probability) {
                        x2++;
                        //缺课
                        if (ints[i][j] == 1) {
                            probability = 100;
                            absenteeism++;
                            x1++;
                        }
                        //到勤
                        else {

                        }
                    }
                    students.set(i, student);
                    student.setProbability(probability);//点名概率
                    student.setAbsenteeism(absenteeism);//缺点次数
                }
            }
            System.out.print("第" + filename + "个班级的E = ");
            System.out.println(x1 / x2);
            ans[filename - 1] = x1 / x2;
            avg += x1 / x2;
        }
        avg /=5;
        for(int i = 0 ; i< 5 ; i++){
            d += (ans[i]-avg)*(ans[i]-avg);
        }
        d /=5;
        System.out.print("方差 = ");
        System.out.println(d);
    }
}
