package datastructure.recursion;

/**
 * @author: 张锦标
 * @date: 2023/10/15 10:25
 * FindMaxInArray类
 */
public class FindMaxInArray {
    //使用递归的方式寻找数组上的最大值
    public static int findMax(int[]arr,int left,int right){
        if (left==right){
            return arr[left];
        }
        int mid = ((right-left)>>1)+left;
        //求左侧和右侧的最大值
        int leftMax = findMax(arr,left,mid);
        int rightMax = findMax(arr,mid+1,right);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(findMax(arr, 0, arr.length - 1));
    }
}
