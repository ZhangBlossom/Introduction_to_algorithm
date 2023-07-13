package offer.dp.one;

/**
 * @author: 张锦标
 * @date: 2023/7/13 13:50
 * MinCostClimbStairs类
 */
public class MinCostClimbStairs {
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int cur = 0;
        int pre = 0;
        int next = 0;
        for(int i = 2;i<=n;i++){
            next = Math.min(cost[i-1]+cur,cost[i-2]+pre);
            pre = cur;
            cur = next;
        }
        return next;
    }
}
