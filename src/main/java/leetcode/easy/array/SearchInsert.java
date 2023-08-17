package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/16 11:30
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 35
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[0] >= target) {
            return 0;
        }
        if (target == nums[len - 1]) {
            return len - 1;
        }
        if (target > nums[len - 1]) {
            return len ;
        }
        return binarySearch(nums, 0, len, target);
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid + 1] > target) {
                    return mid+1;
                }
                return binarySearch(nums, mid, right, target);
            } else { //nums[mid]>target
                if (nums[mid - 1] < target) {
                    return mid;
                }
                return binarySearch(nums, left, mid, target);
            }
        }
        return 0;
    }
    public int bestSearchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{2,3,5,6,9}, 7));
    }
}
