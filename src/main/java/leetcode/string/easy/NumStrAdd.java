package leetcode.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/17 10:32
 * NumStrAdd类
 */
public class NumStrAdd {
    public static String addStrings(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            pos += num1.length() > i ?  num1.charAt(num1.length() - i - 1) - '0' : 0;
            pos += num2.length() > i ?  num2.charAt(num2.length() - i - 1) - '0' : 0;
            sb.append(pos%10);
            pos/=10;
        }
        if(pos>0){
            sb.append(pos);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
         addStrings("11","123");
    }
}
