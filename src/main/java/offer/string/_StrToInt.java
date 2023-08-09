package offer.string;

/**
 * @author: 张锦标
 * @date: 2023/6/20 16:49
 * StrToInt类
 */
public class _StrToInt {
    public static int strToInt(String str) {
        str = str.trim();
        //数据格式不合理 直接返回0
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0)!='-' && str.charAt(0)!='+'){
            return 0;
        }
        //判断正负号 然后确定从那个索引开始
        int i = str.charAt(0) == '+' || str.charAt(0) == '-' ? 1 : 0;
        //判断正负
        boolean neg = str.charAt(0) == '-';
        int sum = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            //得到当前数字
            int digit = str.charAt(i++) - '0';
            //在最大Integer数值/10开始判断是否溢出
            //当前位已经大于最大/10那么直接返回最大
            if ((!neg) && (sum > (Integer.MAX_VALUE / 10) || (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            //当前数据负数并且已经比最小负数/10还大了（实际上就是更小了）
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
