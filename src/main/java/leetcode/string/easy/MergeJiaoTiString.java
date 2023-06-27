package leetcode.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/6 21:02
 * MergeJiaoTiString类
 */
public class MergeJiaoTiString {
    //暴力解法
    public static String mergeAlternately1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] arr = new char[m + n];
        for (int i = 0; i < Math.min(m, n); i++) {
            arr[i * 2] = word1.charAt(i);
        }
        int index = 0;
        for (int i = 1; i < 2 * Math.min(m, n); i += 2) {
            arr[i] = word2.charAt(index++);
        }
        if (m > n) {
            for (int i = 2 * Math.min(m, n), j = Math.min(m, n); j < Math.max(m, n); j++, i++) {
                arr[i] = word1.charAt(j);
            }
        } else {
            for (int i = 2 * Math.min(m, n), j = Math.min(m, n); j < Math.max(m, n); j++, i++) {
                arr[i] = word2.charAt(j);
            }
        }
        return new String(arr);
    }

    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < m || i < n) {
            if (i < m) {
                sb.append(word1.charAt(i));
            }
            if (i < n) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public String mergeAlternately3(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int min = Math.min(n1, n2), max = Math.max(n1, n2), i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < min) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        String longWord = n1 == max ? word1 : word2;
        while (i < max) {
            sb.append(longWord.charAt(i++));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately1("abc123", "pqr23345"));
    }
}
