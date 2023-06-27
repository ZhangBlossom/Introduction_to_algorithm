package leetcode.easy.array;

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

    public static  int findPoisonedDuration1(int[] timeSeries, int duration){
        if (duration == 0) {
            return 0;
        } else if (timeSeries.length == 1) {
            return duration;
        }
        int total = 0;
        for(int i=1;i<=timeSeries.length-1;i++){
            if (timeSeries[i]-timeSeries[i-1]+1<=duration){
                total+=duration;
            }else{
                total+=timeSeries[i]-timeSeries[i-1];
            }
        }
        return total+duration;
    }
}

