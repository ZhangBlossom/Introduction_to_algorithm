package offer.sort;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/13 14:27
 * HeapSort类
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        //创建一个大顶堆
        //一开始需要从最后一个非叶子节点开始创建
        //所以i是从最后一个叶子节点的位置开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            arr[0] ^= arr[i];
            arr[i] ^= arr[0];
            arr[0] ^= arr[i];
            adjustHeap(arr, 0, i);
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


    //降序操作
    public void sort(int arr[]) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 逐步将最大元素移到末尾
        for (int i = n - 1; i > 0; i--) {
            // 将当前最大元素（根节点）与末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新构建最大堆
            heapify(arr, i, 0);
        }
    }
    // 堆化操作：将指定节点及其子树调整为最大堆

    /**
     * @param arr
     * @param n   n为限制范围
     * @param i   i为开始排序的索引位置
     */
    void heapify(int arr[], int n, int i) {
        int largest = i; // 初始化最大值为父节点
        int left = 2 * i + 1; // 左子节点的索引
        int right = 2 * i + 2; // 右子节点的索引

        // 如果左子节点大于父节点，更新最大值索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点大于当前最大值，更新最大值索引
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前父节点，进行交换，并递归调用堆化操作
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 1, 23, 123, 123, 1, 435, 4, 364, 56};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
