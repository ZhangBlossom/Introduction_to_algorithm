package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/28 9:17
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 136
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


    public static void main(String[] args) {
        singleNumber(new int[]{4,1,2,1,2});
    }
}
