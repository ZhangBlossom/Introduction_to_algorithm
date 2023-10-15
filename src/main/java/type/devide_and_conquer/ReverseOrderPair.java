package type.devide_and_conquer;

/**
 * @author: 张锦标
 * @date: 2023/10/15 14:27
 * ReverseOrderPair类
 * 逆序对问题，左边的数据如果比右边的大，则这两个数构成一个逆序对。打印出所有的逆序对
 */
public class ReverseOrderPair {
    public static void reverseOrderPair(int[] arr, int left, int right) {
        if (left==right){
            return ;
        }
        int mid = ((right - left) >> 1) + left;
        reverseOrderPair(arr, left, mid);
        reverseOrderPair(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2];
                System.out.println(arr[p1] + "-" + arr[p2]);
                p2++;
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[]arr = new int[]{3,2,1,0};
        reverseOrderPair(arr,0,arr.length-1);
    }
}
