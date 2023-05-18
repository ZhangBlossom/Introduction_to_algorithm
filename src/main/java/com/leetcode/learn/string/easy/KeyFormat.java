package com.leetcode.learn.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/18 11:50
 * KeyFormat类
 */
public class KeyFormat {
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                sb.append((c+"").toUpperCase());
            }
        }
        String s1 = sb.toString();
        if (s1.length()==0){
            return "";
        }
        int firstLen = s1.length() % k;
        StringBuilder b = new StringBuilder();
        if (firstLen == 0) {
            b.append(s1.substring(0, k));
            b.append("-");
            for (int i = 1; i < s1.length() / k; i++) {
                b.append(s1.substring(k * i, k * (i + 1)));
                b.append("-");
            }
        } else {
            b.append(s1.substring(0, firstLen));
            b.append("-");
            for (int i = firstLen; i < s1.length(); i += k) {
                b.append(s1.substring(i, i + k));
                b.append("-");
            }
        }
        return b.toString().substring(0,b.toString().length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J",  2));
    }
}
