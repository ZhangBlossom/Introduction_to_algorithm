package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/20 22:40
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class MergeSortedArray {
    //    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i=m,j=0;i<nums1.length;i++){
//            nums1[i]=nums2[j++];
//        }
//        Arrays.sort(nums1);
//    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 3, 4}, 3);
    }
}
