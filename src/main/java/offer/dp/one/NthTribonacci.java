package offer.dp.one;

/**
 * @author: 张锦标
 * @date: 2023/7/13 13:43
 * NthTaibonaqi类
 */
public class NthTribonacci {
    public static int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1, t3 = 2;
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        for (int i = n; i - 3 >= 0; i--) {
            t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }
        return t3;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
