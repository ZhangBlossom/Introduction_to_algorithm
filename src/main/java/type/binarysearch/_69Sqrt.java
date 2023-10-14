package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/14 14:09
 * _69Sqrt类
 */
public class _69Sqrt {
    class Solution {
        public int mySqrt(int x) {
            int left = 0;
            int right = x;
            int res = -1;
            while (left<=right){
                int mid = (right-left)/2+left;
                long square = (long)mid*mid;
                if (square<=x){
                    res = mid;
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            return res;
        }
    }
}
