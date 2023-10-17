package datastructure.sort;

import java.util.Arrays;

public class HeapSortX {
    public static void heapSort(int[] arr) {
        int size = arr.length;

        // 构建最大堆
        buildMaxHeap(arr);

        // 从最后一个元素开始，逐步将最大元素移到数组末尾
        for (int i = size - 1; i > 0; i--) {
            // 交换堆顶元素（最大元素）与当前末尾元素
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新调整堆，排除已排序部分，使其继续满足最大堆性质
            heapify(arr, i, 0);
        }
    }

    // 构建最大堆
    private static void buildMaxHeap(int[] arr) {
        int size = arr.length;
        // 从最后一个非叶子节点开始，向上逐步调整每个子树，使其满足最大堆性质
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    // 调整堆，使其满足最大堆性质
    public static void heapify(int[] arr, int size, int root) {
        int largest = root; // 初始化最大元素的索引为根节点
        int left = 2 * root + 1; // 左孩子节点的索引
        int right = 2 * root + 2; // 右孩子节点的索引

        // 比较左孩子与根节点，找出最大元素的索引
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // 比较右孩子与根节点，找出最大元素的索引
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大元素不是根节点，交换根节点与最大元素
        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // 递归调整被交换的子树，以确保子树也满足最大堆性质
            heapify(arr, size, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        int size = arr.length;

        System.out.println("原始数组: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("堆排序后的数组: " + Arrays.toString(arr));
    }
}
