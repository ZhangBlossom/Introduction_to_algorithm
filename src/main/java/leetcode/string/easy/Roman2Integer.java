package leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/5/11 18:28
 * Roman2Integer类
 */
public class Roman2Integer {
    public static int romanToInt(String s) {
        int sum=0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.toCharArray().length; i++) {
            int cur = getValue(s.charAt(i));
            if (pre<cur){
                sum-=pre;
            }else{
                sum+=pre;
            }
            pre = cur;
        }
        sum+=pre;
        return sum;
    }
    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int romanToInt2(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
