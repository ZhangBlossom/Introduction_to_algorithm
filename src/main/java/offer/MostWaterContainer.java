package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/28 11:20
 * MostWaterContainer类
 */
public class MostWaterContainer {
    public int maxArea(int[] height){
        int len = height.length;
        int left = 0;
        int right = len-1;
        int area = 0;
        int high = 0;
        while(left<right){
            high = Math.min(height[left],height[right]);
            if (((right-left)*high)>area){
                area = (right-left)*high;
            }
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
