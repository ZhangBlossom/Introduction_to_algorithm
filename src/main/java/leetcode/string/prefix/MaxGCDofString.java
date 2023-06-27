package leetcode.string.prefix;

/**
 * @author: 张锦标
 * @date: 2023/6/6 21:45
 * MaxGCDofString类
 */
public class MaxGCDofString {
    public static String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        for (int i = Math.min(m, n); i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    private static boolean check(String x, String str1) {
        int len = str1.length() / x.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            sb.append(x);
        }
        return sb.toString().equals(str1);
    }

    public static void main(String[] args) {
        gcdOfStrings("ABCABC","ABC");
    }
}
