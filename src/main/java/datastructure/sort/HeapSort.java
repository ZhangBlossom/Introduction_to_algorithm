package datastructure.sort;

import java.util.Arrays;

/*
 * 使用堆排序需要了解二叉树
 * 其实堆排序就是大顶堆或者小顶堆 每次都将
 * 最大或者最小的数据先移动到非叶子结点位置
 * 将结点与最后一个结点进行数据交换
 * 多次循环下来就可以得到一个有序的
 * 建议用草纸模拟一下堆排序的过程
 * */
public class HeapSort {
    /*
     * 使用堆排序需要了解二叉树
     * 其实堆排序就是大顶堆或者小顶堆 每次都将
     * 最大或者最小的数据先移动到非叶子结点位置
     * 将结点与最后一个结点进行数据交换
     * 多次循环下来就可以得到一个有序的
     * 建议用草纸模拟一下堆排序的过程*/
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 10, 4, 7, 3, 4};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        //将无序序列构建成一个大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("初始构造大顶堆" + Arrays.toString(arr));
        //将对顶元素与末尾元素进行交换 将最大数据沉到末尾
        //重新调整结构 使其满足堆定义 然后继续交换当前与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            arr[j] ^= arr[0]; //交换
            arr[0] ^= arr[j];
            arr[j] ^= arr[0];
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    待调整数组
     * @param i      当前非叶子结点再数组中的索引
     * @param length 当前可操作数据的长度 对于大顶堆最大的数据再数组最后之后就会被抛弃不在操作
     *               因此length--
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //将当前非叶子结点保存
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {//k=2*i+1则k代表的是当前非叶子结点的左孩子
            if (k + 1 < length && arr[k] < arr[k + 1]) {//判断左孩子大还是右孩子大
                k++;//如果是右孩子大就++获得到右孩子的索引
            }
            if (arr[k] > temp) {//判断孩子大还是当前结点大
                arr[i] = arr[k]; //将更大的向上排
                i = k; //大的元素就跑到了非叶子结点的索引去 然后让i去更小数据的索引
            } else {
                break;//由于i是从下往上的 所以如果当前的非叶子结点更大直接退出就好 因为假设是一个
                //4层8结点的完全二叉树 那么i=3一开始 然后arr[7]<arr[3]那么直接break后
                //下一次i=2(i=3那个结点的双亲结点) 然后i=1 i=0
            }
        }
        arr[i] = temp;//大的数据被移上去了 但是其原有位置的数据还没有被修改
    }   //因此这一步操作就是为了修改那个数据

}
