package data;

import pojo.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandAttendance {
    //缺勤百分之80的人
    public  HashSet<Integer> Rand1(){
        int number = new Random().nextInt(4)+5;
        HashSet<Integer> set = new HashSet<Integer>();
        int size = set.size();
        for(size = 0;size<number;)
        {
            int num = new Random().nextInt(90);
            set.add(num);// 将不同的数存入HashSet中
            size = set.size();
        }
//        for (int j : set) {
//            System.out.println(j);
//        }
        return set;
    }
 //   public static void main(String[] args){
    public  int[] Rand2(){
        HashSet<Integer> set = new HashSet<Integer>();
        int size = set.size();
        int [] courses = new int[20];
        for(size = 0;size<16;)
        {
            // 调用Math.random()方法c h
            int num = new Random().nextInt(20);
            set.add(num);// 将不同的数存入HashSet中
            size = set.size();
            //      set.contains(11); 判断是否存在
        }
//        for (int j : set) {
//            System.out.println(j);
//        }
        for(int i = 0 ; i<20 ; i++){
            courses[i] = 0;
            if(set.contains(i))
            {
                courses[i] = 1;
            }
      //     System.out.println(courses[i]);
        }

        return courses;
    }
    //每节课缺勤的同学0~3位
    public ArrayList<Student> Rand3(ArrayList<Student> students, HashSet<Integer> attendance){

        for(int i = 0;i<20;i++)
        {
            HashSet<Integer> set = attendance;
            int num = new Random().nextInt(4);
            int size_flag = set.size();
            int size = set.size();
            for (; size<num+size_flag ; ){
                int number = new Random().nextInt(90);
                set.add(number);// 将不同的数存入HashSet中
                int size_01 = set.size();
                if(size_01>size){
                    students.get(number).setAttendance(i);
                }
                size = size_01;
            }
        }
//        for (int j : set) {
//            System.out.println(j);
//        }
        return students;
    }

}
