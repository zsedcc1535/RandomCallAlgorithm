package test;

import algorithm.GetData;
import pojo.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        int[] end = new int[20];
        float max = 0;
        int probability_max = 0;
        float x1_max = 0;
        float x2_max = 0;
        GetData getData = new GetData();
        ArrayList<Student> students = new ArrayList<>(); //学生数据集
        try {
            students = getData.GetRandData(1);
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
//        //测试输出ints
//        for(int i = 0 ; i<90 ; i++){
//            for(int j = 0 ; j<20 ; j++){
//                if(j == 19) System.out.println(ints[i][j]);
//                else System.out.print(ints[i][j]);
//            }
//        }
        for(int i = 0;i<90;i++) {
            for (int test = 0; test <= 100; test++) {
                max = 0;
                probability_max = 0;
                Student student = new Student();
                student = students.get(i);
                for (int q = 0; q < 1000; q++) {
                    float x1 = 0;//有效点名次数
                    float x2 = 0;//总点名次数
                    int absenteeism = student.getAbsenteeism();//缺点次数
                    int probability = test;
                    for (int j = 0; j < 20; j++) {
                        int num = new Random().nextInt(101);
                        //点到了
                        if (num <= probability) {
                            x2++;
                            //缺课
                            if (ints[i][j] == 1) {
                                absenteeism++;
                                x1++;
                            }
                        }
                    }
                    if (x1 / x2 > max) {
                        max = x1 / x2;
                        probability_max = probability;
                        x1_max = x1;
                        x2_max = x2;
                    }
                }
//                System.out.print(x1 / x2);
//                System.out.print(" " + x1);
//                System.out.println(" " + x2);
            }
            if(max != 0)
                System.out.println("student"+(i+1)+ "  MaxE = "+max + "   probability =  " + probability_max);
        }
    }
}
