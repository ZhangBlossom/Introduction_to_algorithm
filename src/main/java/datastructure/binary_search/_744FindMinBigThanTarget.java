package datastructure.binary_search;

/**
 * @author: 张锦标
 * @date: 2023/10/12 21:10
 * _744FindMinBigThanTarget类
 * 当前类用于二分查找比给定的target大的最小的值
 */
public class _744FindMinBigThanTarget {
    public int nextGreastestLetter(char[]letters,char target){
        int len = letters.length;
        if (target>=letters[len-1]){
            return letters[0];
        }
        int left = 0;
        int right = len-1;
        //注意这里必须是< 如果加一个=就是死循环
        while(len<right){
            int mid = (left+right)/2;
            if (target<letters[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return letters[left];
    }
}
