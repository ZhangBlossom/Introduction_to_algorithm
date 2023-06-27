package leetcode.easy.array;

/**
 * @author: 张锦标
 * @date: 2023/6/26 11:43
 * ArrSumAbsSum类
 */
public class ArrSumAbsSum {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int sum1 = 0;
        int res = 0;
        for (int num : nums) {
            sum+=num;
            int cur = num;
            while(cur>0){
                sum1+=cur%10;
                cur/=10;
            }
            res = sum-sum1;

        }
        return Math.abs(res);
    }
}
