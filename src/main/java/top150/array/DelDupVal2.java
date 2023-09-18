package top150.array;

/**
 * @author: 张锦标
 * @date: 2023/9/18 9:24
 * DelDupVal2类
 * 我们将原问题的「保留 2 位」修改为「保留 k 位」。
 *
 * 对于此类问题，我们应该进行如下考虑：
 *
 * 由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留
 * 对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k
 * 个元素进行比较，不相同则保留
 *
 */
public class DelDupVal2 {
    //public int removeDuplicates(int[] nums) {
    //    int n = nums.length;
    //    if (n <= 2) {
    //        return n;
    //    }
    //    int slow = 2, fast = 2;
    //    while (fast < n) {
    //        if (nums[slow - 2] != nums[fast]) {
    //            nums[slow] = nums[fast];
    //            ++slow;
    //        }
    //        ++fast;
    //    }
    //    return slow;
    //}

    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }

}
