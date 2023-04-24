package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/20 15:41
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class ClimbStairs {
    //滚动矩阵
    //爬上第n级楼梯可以知道有如下规律
    //只要知道爬上n-2和n-1层楼梯有多少种方法
    //然后将他们相加即可
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static void main(String[] args) {

    }
}
