package offer.prefixsum;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/6/30 15:57
 * HigestAltitude类
 */
public class HigestAltitude {
    /*
    输入：gain = [-5,1,5,0,-7]
    输出：1   [0,-5,-4,1,1,-6]
     */
    public int largestAltitude1(int[] gain) {
        int n = gain.length;
        int[] res = new int[n+1];
        res[0]=0;
        for(int i=0;i<n;i++){
            res[i+1] = res[i]+gain[i];
        }
        Arrays.sort(res);
        return res[n];
    }
    public int largestAltitude(int[] gain){
        int sum = 0;
        int max = 0;
        for (int i : gain) {
            sum+=i;
            max = Math.max(sum,max);
        }
        return max;
    }
}
