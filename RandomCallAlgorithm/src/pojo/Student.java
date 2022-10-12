package pojo;

import java.io.Serializable;
import java.util.Arrays;

//学生实体类，继承Serializable，用以利用objectinputstream存储对象
public class Student implements Serializable {
    private static final long serialVersionUID = 1L ;
    private String name;//姓名
    private String sex;//性别
    private int absenteeism;//缺勤次数
    private int[] attendance; //到勤情况
    private double grade;//成绩
    private int probability;//抽点概率
    private  int id; //id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int[] getAttendance() {
        return attendance;
    }
    public int getAttendance(int index) {
        return attendance[index];
    }


    public void setAttendance(int[] attendance) {
        this.attendance = attendance;
    }
    public void setAttendance(int index) {
        this.attendance[index] = 1;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        //  String name = this.getName();
        //   String separator = "";
        //  if(name.length() == 2) separator = "   ";
        //  else if(name.length() == 3) separator = " ";
        return "Student{" +
                " name='" +name +'\'' +
                ", sex='" + sex + '\'' +
                " absenteeism=" + absenteeism +
                ", attendance=" + Arrays.toString(attendance) +
                ", grade=" + grade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(int absenteeism) {
        this.absenteeism = absenteeism;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
