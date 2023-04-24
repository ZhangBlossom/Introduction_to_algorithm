package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/18 8:40
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class Sqrt {
    public static int mySqrt(int c) {
//        if(c < 0) return Double.NaN; //既然要开平方，肯定不能为负啊
        double err = 1e-7; //精度
        double x = c; //迭代的初始值
        while(Math.abs(x - c/x) > err){ //没达到精度，那么继续迭代
            x = (x + c/x) / 2.0;
        }
        return (int)x;
    }
    public static double sqrt(double c) {
//        if(c < 0) return Double.NaN; //既然要开平方，肯定不能为负啊
        double err = 1e-7; //精度
        double x = c; //迭代的初始值
        while(Math.abs(x - c/x) > err){ //没达到精度，那么继续迭代
            x = (x + c/x) / 2.0;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(3));
    }
}
