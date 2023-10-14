package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/14 13:46
 * _367IsPerfectSquare类
 */
public class _367IsPerfectSquare {
    public boolean isPerfectSquare(int num){
        int left = 0;
        int right = num;
        while (left<=right){
            int mid = (right-left)/2+left;
            long square = (long)mid*mid;
            if (square<num){
                left = mid+1;
            }else if(square>num){
                right = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
