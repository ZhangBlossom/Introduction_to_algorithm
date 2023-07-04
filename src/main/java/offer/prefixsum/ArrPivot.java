package offer.prefixsum;

/**
 * @author: 张锦标
 * @date: 2023/6/30 18:20
 * ArrPivot类
 */
public class ArrPivot {
    public static int pivotIndex(int[] nums){
        //[1, 7, 3, 6, 5, 6]
        int n = nums.length; //6
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        leftArr[0] = 0;
        rightArr[n-1] = 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int i=1;i<n;i++){
            leftArr[i] = nums[i-1]+leftArr[i-1];//leftArr: 0 1 4
            rightArr[n-i-1] = nums[n-i]+rightArr[n-i]; //right:         6 0
        }
        for(int i=0;i<n;i++){
            if (leftArr[i]==rightArr[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }
}
