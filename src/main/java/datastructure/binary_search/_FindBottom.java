package datastructure.binary_search;

/**
 * @author: 张锦标
 * @date: 2023/10/14 21:43
 * _FindBottom类
 * 寻找局部最小和寻找局部最大
 *
 */
public class _FindBottom {
    public int findBottom(int[]arr){
        if (arr[0]<arr[1]){
            return 0;
        }
        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int left = 1;
        int right = arr.length-2;
        int res = 1;
        while(left<=right){
            int mid = (right-left)/2+left;
            if (arr[mid]>arr[mid+1]){
                left = mid+1;
                res=  mid;
            }else{
                right = mid-1;
            }
        }
        return res;
    }
}
