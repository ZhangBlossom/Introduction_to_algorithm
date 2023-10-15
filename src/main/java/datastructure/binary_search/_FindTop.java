package datastructure.binary_search;

/**
 * @author: 张锦标
 * @date: 2023/10/14 16:14
 * _852FindMountain类
 */
public class _FindTop {
        //寻找最高点
          public int peakIndexInMountainArray(int[] arr) {
             int left = 1;
             int right = arr.length - 2;
             int res = 0;
             while(left<=right){
                 int  mid = (right-left)/2+left;
                 if (arr[mid]>arr[mid+1]){
                     right = mid-1;
                     res = mid;
                 }else{
                     left = mid+1;
                 }
             }
             return res;
         }

        int peakIndexInMountainArray2(int[] arr) {
            int n = arr.length;
            int ans = -1;
            for (int i = 1; i < n - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    ans = i;
                    break;
                }
            }
            return ans;
        }

}
