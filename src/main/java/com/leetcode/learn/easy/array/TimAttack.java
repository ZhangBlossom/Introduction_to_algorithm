package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/14 9:17
 * Description:
 * Version: 1.0.0
 * 495
 */
public class TimAttack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        } else if (timeSeries.length == 1) {
            return duration;
        }
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1 ; i++) {//1 4 5  - 2
            if ((timeSeries[i + 1]-timeSeries[i])-duration>=0) {
                result+=duration;
            }else{
                result+=timeSeries[i+1]-timeSeries[i];
            }
        }
        result+=duration;
        return result;
    }
}
