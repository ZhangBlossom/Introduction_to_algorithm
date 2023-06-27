package leetcode.tanxing.middle;

import java.util.Arrays;

public class LiheZuiTian{
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        // 二分模板·其三（开区间写法）https://www.bilibili.com/video/BV1AP41137w7/
        int left = 0, right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：
            // f(left) >= k
            // f(right) < k
            int mid = left + (right - left) / 2;
            if (f(price, mid) >= k) {
                left = mid; // 下一轮二分 (mid, right)
            } else {
                right = mid; // 下一轮二分 (left, mid)
            }
        }
        return left;
    }

    private int f(int[] price, int d) {
        int cnt = 1, pre = price[0];
        for (int p : price) {
            if (p >= pre + d) {
                cnt++;
                pre = p;
            }
        }
        return cnt;
    }
}

