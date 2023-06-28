package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/28 9:23
 * ProductExceptSelf类
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums){
        int len = nums.length;
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];
        int[] res = new int[len];
        leftArr[0] = 1;
        rightArr[len-1] = 1;
        for(int i=1;i<len;i++){
            leftArr[i] = leftArr[i-1] * nums[i-1];
        }
        for(int i=len-2;i>=0;i--){
            rightArr[i] = rightArr[i+1] * nums[i+1];
        }
        for(int i=0;i<len;i++){
            res[i] = leftArr[i] * rightArr[i];
        }
        return res;
    }
}
