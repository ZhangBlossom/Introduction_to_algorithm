package leetcode.tanxing.middle;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/8/9 21:53
 * MoneyChanger类
 */
public class CoinChanger {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //设定到达小于amount金额的每一个金额需要的硬币数量
        int[] dp = new int[amount + 1];
        //初始化初始数组  设定一个金额 金额大于amount即可
        //用于后续选择最小值
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        //i循环的是到达每一个金额的情况
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //判断当前硬币是不是小于等于当前金额
                //毕竟如果硬币直接超过了当前金额肯定就得不到了
                if (coins[j] <= i) {
                    //当前需要的硬币数量为：到达上一个金额的硬币数量+1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
