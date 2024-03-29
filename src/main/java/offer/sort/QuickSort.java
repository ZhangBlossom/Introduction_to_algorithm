package offer.sort;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/13 14:20
 * QuickSort类
 */
public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[left] < pivot) {
                left++;
            }
            while(left < right && arr[right] > pivot) {
                right--;
            }
            //走到这个if说明 left已经大于pivot
            //right也小于了pivot
            if (left < right && arr[left] == arr[right]) {
                left++;
            }else{// 那么此时直接交换两个大小的值 更加有序
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            if (start<left-1){
                quickSort(arr,start,left-1);
            }
            if (right+1<end){
                quickSort(arr,right+1,end);
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = new int[]{12,1,23,123,123,1,435,4,364,56};
        quickSort(arr,0,9);
        System.out.println(Arrays.toString(arr));
    }
}
