package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/31 13:54
 * Description:
 */
public class QuickSort {
    /*
     * 快速排序 找到一个中轴 让中轴左边小于中轴 右边大于中轴
     * 然后把左边的再次按上面的方法进行
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        //pivot中轴值
        int pivot = arr[(left + right) / 2];
        //while循环是为了让左边小于pivot 右边大于pivot
        while (l < r) {//左下标还小于右下标
            while (arr[l] < pivot) {//在pivot左边一直找 直到找到的数据大于pivot退出
                l++;
            }//退出时arr[l]>=pivot
            while (arr[r] > pivot) {//在pivot右边一直找 直到找到比pivot小的退出
                r--;
            }//退出时arr[r]>pivot
            if (l >= r) {
                break;//如果按照上面的寻找方法使得l>=r说明左边的已经都小于pivot
                //右边的都大于pivot了
            }
            //如果没有成立 那么就交换此时的左值和右值 因为他们不合理
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            //交换后l指向arr[r] r指向arr[l]
            //如果交换后arr[l]==pivot 那么r--
            if (pivot == arr[l]) {//arr[l]==pivot说明之前是r指向了pivot 那么之后r继续左移
                r--;
            }
            if (pivot == arr[r]) {//反之右移
                l++;
            }
        }
        //如果l==r 必须l++和r-- 否则栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    public static int[] qsort(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            //当i和j两个指针停下的时候
            //arr[i]>=pivot的
            //arr[j]<=pivot的
            //如果相等那么让左指针继续++
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {//不相等说明arr[i]<arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = qsort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = qsort(arr, j + 1, end);
        }
        return (arr);
    }

    public static int[] quickSortX(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[left] < pivot) {
                left++;
            }
            while (left < right && arr[right] > pivot) {
                right--;
            }
            if (left < right && arr[left] == arr[right]) {
                left++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if (start < left - 1) {
            arr = quickSortX(arr, start, left - 1);
        }
        if (right + 1 < end) {
            arr = quickSortX(arr, right + 1, end);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 123, 5, 3425, 2130, -4365, -123};
        quickSortX(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
 