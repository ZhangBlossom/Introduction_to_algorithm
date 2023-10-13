package keypoint.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/13 16:25
 * FindLeftAndRight类
 * 二分查找中寻找最左边和最右边的元素的方法
 */
public class FindLeftAndRight {
    //当前方法用于返回nums数组中的最左边的target值
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //这里是左闭右开区间
    //当前方法用于返回nums数组中的最左边的target值
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; //right
    }


    //这里是左开右开区间
    //当前方法用于返回nums数组中的最左边的target值
    public static int binarySearch3(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left+1 < right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }


    //寻找nums数组中最左边的target
    public int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            //解决数据大小溢出的问题
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    //寻找nums数组中最右边的target
    public int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            //解决数据大小溢出的问题
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int target = 4;
        int left = binarySearch(new int[]{1, 2, 3, 4}, 4);
        //因为当前方法会得到最左边的值
        //那么再整数数组中 当前target+1 就可以得到最小的target+1的值
        //然后再-1 就可以得到最大的哪一个值了
        int right = binarySearch(new int[]{1, 2, 3, 4}, target + 1) - 1;
    }
}
