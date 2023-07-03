package offer.bit;

/**
 * @author: 张锦标
 * @date: 2023/7/2 12:03
 * MinFlipOfOR类
 */
public class MinFlipOfOR {
    public static int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int bit_a = (a >> i) & 1;
            int bit_b = (b >> i) & 1;
            int bit_c = (c >> i) & 1;
            //上面已经得到当前位的二进制数了
            if (bit_c == 0) { //当前bit_c == 0 需要反转的个数为1的个数
                ans+=bit_a+bit_b;
            }
            else { //bit_c == 1 反转个数为0的个数
                //当且仅当a和b都为1才需要翻转
                ans+=(bit_a | bit_b) ^ 1; //只有a和b都为0才会使用抑或+1
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
    }
}
