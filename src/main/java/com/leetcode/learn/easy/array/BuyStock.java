package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/27 11:16
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class BuyStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int earn = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            earn = Math.max(earn, prices[i] - min);
        }
        return earn;
    }

    public static void main(String[] args) {

    }
}
