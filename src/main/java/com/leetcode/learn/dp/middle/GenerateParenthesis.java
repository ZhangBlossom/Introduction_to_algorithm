package com.leetcode.learn.dp.middle;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/6/15 10:28
 * GenerateBracket类
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis1(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n-1)) {
            for (int i = 0; i < 2*n-2; i++) {
                hs.add(s.substring(0,i) + "()" + s.substring(i,s.length()));
            }
        }
        return new ArrayList(hs);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateOne(res, "", n, n);
        return res;
    }

    private void generateOne(List<String> list, String string, int left, int right) {
        // left, rigth 分别代表可用的左括号数和可用的右括号数，初始都是 n个可用
        if (left == 0 && right == 0) {
            list.add(string);
            return;
        }

        if (left > 0) {
            generateOne(list, string + "(", left - 1, right);
        }

        // 可用的括号 右括号大于左括号时，说明有 左括号先放置，才会是有效的括号组合
        if (right > left) {
            generateOne(list, string + ")", left, right - 1);
        }

    }
    public static void main(String[] args) {

    }
}
