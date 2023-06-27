package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/25 18:34
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class SquareArray {
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[]result = new int[nums.length];
        int index = nums.length-1;
        while (left<=right){
            int low = nums[left] * nums[left];
            int high = nums[right] * nums[right];
            if (low>high){
                result[index--] = low;
                left++;
            }else{
                result[index--] = high;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
