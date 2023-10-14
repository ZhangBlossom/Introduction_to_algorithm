package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/14 14:13
 * _441ArrangeCoins类
 */
public class _441ArrangeCoins {
    //这道题需要考虑使用等差数列
    public int arrangeCoins(int n){
        int left = 1;
        int right = n;
        while(left<right){
            int mid = (right-left+1)/2+left;
            if ((long)mid*(mid+1)<=(long) 2*n){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
