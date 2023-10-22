package type.dp;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/10/22 16:24
 * CookOrder类
 */
public class CookOrder {
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            int n = satisfaction.length;
            int[][] dp = new int[n + 1][n + 1];
            Arrays.sort(satisfaction);
            int res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j;
                    if (j < i) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }
    }
}
