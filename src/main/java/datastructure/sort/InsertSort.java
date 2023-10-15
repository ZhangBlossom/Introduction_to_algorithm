package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/30 17:25
 * Description:
 * 插入排序
 * 时间复杂度 O（n2)
 * 空间复杂度 O（1）
 * 插入排序的概念是：每次选取一个索引，从0开始。然后判断当前数据是不是比前面一个小，
 * 如果是，那么就开始交换，并且一直交换，直到比前面的大，或者前面没有数据了为止。
 * 因此插入在高度有序的情况下，时间复杂度O（n），最差O（n2）
 * 插入排序一般性能都比冒泡和选择排序好 因为他会在数据有序的时候直接结束内循环
 */
public class InsertSort {
    //当前这里是存在了一个哨兵节点
    private static int[] arr = new int[]{0,3, 5412, 12, 3, 513, -1, 6, -324};
    public static void insertSort(int[]arr){
        for(int i = 1;i<arr.length;i++){
            //这里的条件判断就是j前面还有数据，并且前面的j比后面的数据大
            //那么就需要进行一次交换
            for(int j = i-1;j>=0 && arr[j]>arr[j+1];j--){
                arr[j]^=arr[j+1];
                arr[j+1]^=arr[j];
                arr[j]^=arr[j+1];
            }
        }
    }

    public static void main(String[] args) {
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
