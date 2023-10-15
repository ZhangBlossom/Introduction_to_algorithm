package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/30 15:30
 * Description:
 * 冒泡排序
 * 时间复杂度 O（n2）
 * 空间复杂度 O（1）
 * 冒泡排序的思想是，从第一个开始遍历，然后每次都把比较大的数据
 * 移动到后面去，那么在第一次交换的时候，最大的数据已经到最后去了，
 * 以此类推，第二次冒泡的话，倒数第二个就是倒数第二大的数据。
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean flag = false;
        //这是第几轮
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            //这一层的for循环的意思就是当前轮需要包含的数据的个数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数据更大，那么就需要进行交换
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    flag = true;
                }
            }
            //如果此时已经没有数据更新，那么说明已经有序，直接跳出循环
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5412, 12, 3, 513, -1, 6, -324};
        bubbleSort(arr);
    }
}

