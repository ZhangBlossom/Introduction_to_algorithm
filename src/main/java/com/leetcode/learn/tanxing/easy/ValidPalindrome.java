package com.leetcode.learn.tanxing.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/3 10:09
 * ValidPalindrome类
 * 验证回文子串
 * 使用双指针可以判断当前字符串是不是回文串
 * 使用递归对内部字符串再次判断是否是回文串
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length();
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else{
                return isPalidrome(s,low,high-1) || isPalidrome(s,low+1,high);
            }
        }
        return true;
    }
    public boolean isPalidrome(String s,int low,int high){
        for (int i = low,j=high; i < j;++i,--j) {
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
