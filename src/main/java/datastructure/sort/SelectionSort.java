package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/30 15:41
 * Description:
 * 选择排序
 * 思路是从第一个开始遍历，然后每次都选择最小的哪一个放到前面去
 * 时间复杂度 O（n^2）
 * 空间复杂度 O（1）
 */
public class SelectionSort {
    public static void selectionSort(int[]arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int p = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    p = j;
                }
            }
            if (p != i) {
                arr[p] = arr[i];
                arr[i] = min;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5412, 12, 3, 513, -1, 6, 123,123,234,5345,-324};
        selectionSort(arr);
    }
}
