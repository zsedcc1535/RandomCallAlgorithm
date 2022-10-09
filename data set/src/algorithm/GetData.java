package algorithm;

import pojo.Student;

import java.io.*;
import java.util.ArrayList;

//取出数据
public class GetData {
//    public static void main(String[] args) throws IOException;
    public ArrayList<Student> RandData() throws IOException {
        File file = new File(".\\test.dat"); // 打开文件
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students =  (ArrayList<Student>)(ois.readObject());
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        for(Student oneUser:students)
//        {
//            System.out.println(oneUser);
//        }
        return students;
    }
}
