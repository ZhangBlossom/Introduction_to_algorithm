package lcp;

/**
 * @author: 张锦标
 * @date: 2023/6/26 11:29
 * Robot17类
 */
public class Robot17 {
    public static int calculate(String s) {
        int x = 1;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x+y;
    }
}
