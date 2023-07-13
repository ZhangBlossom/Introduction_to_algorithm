package offer.heap;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/12 19:41
 * HeapSort类
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        //先把当前数组构造成一个大顶堆
        //找到树中的最靠后的非叶子节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for(int i = arr.length-1;i>0;i--){
            arr[i]^=arr[0];
            arr[0]^=arr[i];
            arr[i]^=arr[0];
            adjustHeap(arr,0,i);
        }

    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 10, 4, 7, 3, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
