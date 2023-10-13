package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/13 10:22
 * _153SearchRotateArrMin类
 * 找到旋转数组中最小的哪一个数据
 */
public class _153SearchMinInRotateArr {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //如果要找的元素可能出现在数组最后一个位置
        //那么通常用<=

        /*
        考虑以下情况：你正在查找旋转数组中的最小元素。当 nums[mid] < nums[right] 时，
        这表示 mid 处于右侧递增序列中，而最小元素位于 mid 左侧（包括 mid 本身）。
        因此，你将 right 设置为 mid， 以排除掉右侧的递增序列，然后继续查找左侧。
        而 left 设置为 mid + 1，以排除掉 mid 本身，因为你已经确定 mid 处的元素不是最小元素。
         */
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else  {
                left = mid+1;
            }
        }
        return left;
    }
}
