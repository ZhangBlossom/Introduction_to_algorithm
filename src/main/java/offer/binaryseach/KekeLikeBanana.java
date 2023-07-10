package offer.binaryseach;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/10 19:27
 * KekeLikeBanana类
 */
public class KekeLikeBanana {
    //对速度进行二分查找即可
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int min = 1; //最小速度
        int max = 0; //最大速度就是上线
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int res = max;
        while (min < max) {
            int speed = (min + max) / 2;
            int time = getEatingTime(piles, speed);
            if (time <= h) {
                max = speed;
                res = speed;
            } else {
                min = speed + 1;
            }
        }
        return res;
    }

    public int getEatingTime(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(new KekeLikeBanana().minEatingSpeed(new int[]{30,11,23,4,20},6));
    }


}
