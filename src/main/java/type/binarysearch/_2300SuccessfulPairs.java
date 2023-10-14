package type.binarysearch;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/10/14 17:38
 * _2300SuccessfulPairs类
 */
public class _2300SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        Arrays.sort(potions);
        int[]res = new int[m];
        for(int i = 0;i<m;i++){
            int index = getIndex(spells[i],potions,success);
            res[i] = n-index;
        }
        return res;
    }
    public int getIndex(int spell,int[]postions,long success){
        int left =0 ;
        int right = postions.length-1;
        int index = postions.length;
        while(left<=right){
            int mid = (right-left)/2+left;
            if ((long)spell * postions[mid]>=success){
                right = mid-1;
                index = mid;
            }else{
                left = mid+1;
            }
        }
        return index;
    }

}
