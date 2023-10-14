package type.binarysearch;

import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/10/14 14:48
 * _1539MissingK类
 */
public class _1539MissingK {
    public int findKthPositive(int[] arr, int k) {
        int missCount = 0;
        int current = 1;
        int index = 0;
        int lastMiss = -1;
        for (missCount = 0; missCount < k; current++) {
            if (current == arr[index]){
                index = (index+1<arr.length)?index+1:index;
            }else{
                missCount++;
                lastMiss = current;
            }
        }
        return lastMiss;
    }
}
