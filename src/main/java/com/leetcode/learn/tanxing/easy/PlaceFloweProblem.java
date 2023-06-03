package com.leetcode.learn.tanxing.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/3 9:53
 * PlaceFloweProblem类
 */
public class PlaceFloweProblem {
    //数学归纳法
    /*
    统计连续的0的区间，分别有多少个连续的0即可。对于每一段0区间，都可以根据公式直接算出可以种几朵花。
    公式可以通过数学归纳法推出来，很简单：
    1）对于中间的0区间：
    1~2个0：可种0朵；
    3~4个：可种1朵；
    5~6个：可种2朵；
    ..
    count个：可种 (count-1)/2 朵
    2）对于两头的0区间，由于左边、右边分别没有1的限制，可种花朵数稍有不同。
    为了代码流程的统一，可以在数组最左边、数组最右边分别补1个0，意味着花坛左边、右边没有花。
    这样公式就跟1）相同了。
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroCount = 1;
        int canPlace = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zeroCount++;
            } else {
                canPlace += (zeroCount - 1) / 2;
                if (canPlace >= n) {
                    return true;
                }
                zeroCount = 0;
            }
        }
        zeroCount++;
        canPlace += (zeroCount - 1) / 2;
        return canPlace >= n;
    }

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2);
    }
}
