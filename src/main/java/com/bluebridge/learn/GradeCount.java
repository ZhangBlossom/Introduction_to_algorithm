package main.java.com.bluebridge.learn;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/13 20:07
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 2
 * 成绩统计
 */
public class GradeCount {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D://desktop//1.jpg")));
        oos.writeObject("123");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D://desktop//1.jpg")));
        Object o = ois.readObject();
        System.out.println(o);
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int num = scan.nextInt();
        double yx = 0;
        double jg = 0;
        for(int i = 0; i < num; i++){
            int a = scan.nextInt();
            if(a >= 60){
                if(a >= 85){
                    yx++;
                }
                jg++;
            }
        }
        System.out.println(Math.round(jg*100/num) + "%");
        System.out.println(Math.round(yx*100/num) + "%");
        scan.close();
    }
}
