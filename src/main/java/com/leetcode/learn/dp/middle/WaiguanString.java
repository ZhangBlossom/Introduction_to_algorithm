package com.leetcode.learn.dp.middle;

/**
 * @author: 张锦标
 * @date: 2023/6/18 13:38
 * WaiguanString类
 */
public class WaiguanString {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }


    public String countAndSay1(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int count = 0;
            while(start<str.length()){
                while(count<str.length() && str.charAt(count)==str.charAt(start)){
                    count++;
                }
                sb.append(count-start).append(str.charAt(start));
                start = count;
            }

            str = sb.toString();
        }
        return str;
    }
}
