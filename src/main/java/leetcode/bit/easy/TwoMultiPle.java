package leetcode.bit.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/10 11:11
 * TwoMultiPle类
 * 二的倍数
 */
public class TwoMultiPle {
    /**
     * 我们知道如果一个数是2的幂次方
     * 那么该数-1，其所有低位都为1，
     * 那么此时与这个数直接进行与运算，得到的答案是0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
