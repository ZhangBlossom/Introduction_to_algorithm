package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/1 20:04
 * Description:
 * 归并排序
 * 时间复杂度 O（nlogn）
 * 空间复杂度 O（n）
 * 归并排序的思路：
 * 使用递归的方式不断将数组进行拆分，拆分为左右两个等大小的数组。
 * 由于递归的特性，最后会拆分为长度最小为2的一个小区间，之后我们就对这个小区间进行排序即可。
 * 最后，我们就可以得到多个的有序的小区间。
 * 然后递归返回之后，又会继续对这些小区间合并后的一个区间进行合并，然后不断递归返回，
 * 就可以得到最终有序的一个区间了。
 * 而递归调用的一个重要思路就是，使用一个临时数组，这个临时数组用于存放左右区间里的数据，
 * 并且会按照大小进行排序。
 * 思路为，使用p1（左指针），使用p2（右指针）的方式，左指针指向left，右指针指向mid+1，
 * 然后左右指针不断后移，直到越界，左指针边界为left---mid，右指针边界为mid+1---right。
 * 然后将左右指针中指向的更小的数据拷贝到临时数组中，此时临时数组中的元素在区间内有序。
 * 之后将这个区间内有序的数据，覆盖原有的数组即可。
 *
 * 之所以归并排序可以把时间复杂度缩短到nlogn，是因为相对于时间复杂度n2的排序，这些排序浪费了大量的比较功能
 * 而归并排序每次都会比较两个范围的数据，并且将其合并成一个区间内有序的数据，然后再将这个区间去和更大的区间进行
 * 一次排序，那么这样子，他的比较的操作就没有浪费，而是保留了下来。
 */
public class MergeSort {
    public static void mergeSort1(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort1(arr, left, mid, temp);
            mergeSort1(arr, mid + 1, right, temp);
            merge1(arr, left, mid, right, temp);
        }
    }

    public static void merge1(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int tempLeft=left;
        t=0;
        while(tempLeft<=right){
            arr[tempLeft++]=temp[t++];
        }
    }

    public static void mergeSort(int[]arr,int left,int right){
        if (left==right){
            return;
        }
        int mid = ((right-left)>>1)+left;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        //创建一个辅助空间 left--right上有多少个数就开多大的空间
        int[] help = new int[right-left+1];
        int i = 0 ; //提供给help使用的变量
        int p1 = left; //左侧数据的下标
        int p2 = mid+1; //指向mid+1位置
        //判断p1和p2是否越界，如果都不越界
        //那么谁小谁就拷贝到数组help中去
        while(p1<=mid && p2<=right){
            help[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        //继续判断是否有没有拷贝完毕的数据
        //可能是左半部分的p1没有拷贝完毕
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        //也可能是右侧的p2没有拷贝完毕
        while (p2<=right){
            help[i++]=arr[p2++];
        }
        //将help上面有序的数据拷贝到原数组上去，就得到了区间上有序数据
        for(i = 0;i<help.length;i++){
            arr[left+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 123, 53, 123, 65};
        int[] temp = new int[arr.length];
        mergeSort1(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }
}
