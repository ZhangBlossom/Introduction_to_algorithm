package com.leetcode.learn.string;

/**
 * @author: 张锦标
 * @date: 2023/6/10 11:44
 * RecusionHuiwen类
 * 使用递归的方式来判断一个字符串是否是回文串
 */
public class RecusionHuiwen {
    public static boolean isPalindrome(String s,int n,int m){
        if (m<=1){ //递归结束条件
            return true;
        }else if(s.charAt(n)==s.charAt(m-1)){ //判断当前两个对称位置是否相同
            return isPalindrome(s,n+1,m-1); //相同继续向后遍历递归
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(isPalindrome(s, 0, s.length()));
    }

}
