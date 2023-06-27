package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/25 15:27
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 11
 */
public class MostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int v = 0;
        int high = 0;
        int width = 0;
        while (left < right) {
            high = Math.min(height[left], height[right]);
            width = right - left;
            if (v < high * width) {
                v = high * width;
            }
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return v;
    }


    public static void main(String[] args) {

    }
}
