package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/13 10:08
 * SearchRotateArray类
 */
public class _33SearchRotateArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[0] > nums[mid]) {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
