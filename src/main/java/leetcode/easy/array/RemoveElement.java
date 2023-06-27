package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/15 21:59
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 27
 * 删除指定元素
 */
public class RemoveElement {
    /*
    思路

如果要移除的元素恰好在数组的开头，例如序列 [1,2,3,4,5][1,2,3,4,5]，
当 \textit{val}val 为 11 时，我们需要把每一个元素都左移一位。注意到题目中说：
「元素的顺序可以改变」。实际上我们可以直接将最后一个元素 55 移动到序列开头，
取代元素 11，得到序列 [5,2,3,4][5,2,3,4]，同样满足题目要求。
这个优化在序列中 \textit{val}val 元素的数量较少时非常有效。

实现方面，我们依然使用双指针，两个指针初始时分别位于数组的首尾，向中间移动遍历该序列。

算法

如果左指针 \textit{left}left 指向的元素等于 \textit{val}val，
此时将右指针 \textit{right}right 指向的元素复制到左指针 \textit{left}left 的位置，然后右指针
\textit{right}right 左移一位。如果赋值过来的元素恰好也等于 \textit{val}val，
可以继续把右指针 \textit{right}right 指向的元素的值赋值过来（左指针
\textit{left}left 指向的等于 \textit{val}val 的元素的位置继续被覆盖），
直到左指针指向的元素的值不等于 \textit{val}val 为止。

当左指针 \textit{left}left 和右指针 \textit{right}right 重合的时候，
左右指针遍历完数组中所有的元素。

这样的方法两个指针在最坏的情况下合起来只遍历了数组一次。与方法一不同的是，
方法二避免了需要保留的元素的重复赋值操作。

     */
    public int betterRemoveElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] == val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
    /**
     * 相向双指针方法，基于元素顺序可以改变的题目描述改变了元素相对位置，确保了移动最少元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
      public  int removeElementByTwoPoints(int[] nums, int val) {
            int leftIndex = 0;
            int rightIndex = nums.length - 1;
            while (leftIndex <= rightIndex) {
                // 找左边等于val的元素
                while (leftIndex <= rightIndex && nums[leftIndex] != val){
                    ++leftIndex;
                }
                // 找右边不等于val的元素
                while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                    -- rightIndex;
                }
                // 将右边不等于val的元素覆盖左边等于val的元素
                if (leftIndex < rightIndex) {
                    nums[leftIndex++] = nums[rightIndex--];
                }
            }
            return leftIndex;   // leftIndex一定指向了最终数组末尾的下一个元素
        }


    //暴力遍历
    public static int rmElement(int[]nums,int val){
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 3}, 3));
    }
}
