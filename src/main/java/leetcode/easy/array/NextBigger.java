package leetcode.easy.array;

/**
 * @author: 张锦标
 * @date: 2023/6/2 19:43
 * NextBigger类
 * 496 下一个更大元素
 */
public class NextBigger {
    //暴力解法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            w:for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            result[i] = nums2[k];
                            flag = true;
                            break w;
                        }
                    }
                }
            }
            if (!flag) {
                result[i] = -1;
            }
        }
        return result;
    }
}
