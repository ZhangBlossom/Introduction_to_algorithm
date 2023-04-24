package main.java.com.leetcode.learn.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/18 8:59
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class AddBinary {
    public static String addBinary(String a, String b) { //101010 01
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();

    }

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("1235");
        list.add("1234");
        list.add("123");
        System.out.println(new ArrayList<String>(new LinkedHashSet<>(list)));
    }
}
