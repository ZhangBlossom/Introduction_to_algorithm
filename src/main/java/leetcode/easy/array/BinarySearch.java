package leetcode.easy.array;


/**
 * @author: Zhangjinbiao
 * @Date: 2022/10/5 10:16
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 704
 */
public class BinarySearch {
    public static int binarySearch(int find, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (find < arr[mid]) {
                high = mid - 1;
            } else if (find > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursion(int find, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] < find) {
            return binarySearchRecursion(find, arr, mid + 1, high);
        } else if (arr[mid] > find) {
            return binarySearchRecursion(find, arr, low, mid - 1);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,-1,2, 3, 4, 6, 7, 8, 10, 11, 13, 46, 244};
        System.out.println(binarySearchRecursion(-1, arr, 0, arr.length));
        System.out.println(binarySearch(-1, arr));
    }
}
