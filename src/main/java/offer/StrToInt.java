package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/20 16:49
 * StrToInt类
 */
public class StrToInt {
    public static int strToInt(String str) {
        str = str.trim();
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0)!='-' && str.charAt(0)!='+'){
            return 0;
        }

        int i = str.charAt(0) == '+' || str.charAt(0) == '-' ? 1 : 0;
        boolean neg = str.charAt(0) == '-';
        int sum = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i++) - '0';
            if ((!neg) && (sum > (Integer.MAX_VALUE / 10) || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            if (neg && (sum > -(Integer.MIN_VALUE / 10) || (sum == -(Integer.MIN_VALUE / 10) && digit > -(Integer.MIN_VALUE % 10)))) {
                return Integer.MIN_VALUE;
            }
            sum = sum * 10 + digit;
        }
        return neg ? -sum : sum;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("-21474836482"));
    }
}
