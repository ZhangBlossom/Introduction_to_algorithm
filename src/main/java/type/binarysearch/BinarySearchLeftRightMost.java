package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/4/25 19:31
 * BinarySearchLeftRightMost类
 * 这里的代码要求找到最左侧的指定值
 */
public class BinarySearchLeftRightMost {
    public static int binarysearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        //这里是小于等于 如果没有就会少比较一次
        int candidate = -1;
        while (i <= j) {
            //使用移位运算可以保证不出现负数
            int m = (i + j) >>> 1;
            if (target < a[m]) {//目标在左边
                j = m - 1;
            } else if (a[m] < target) { //目标在右边
                i = m + 1;
            } else {//找到了
                //while (a[--m]==target){
                //
                //}
                //return m+1;
                candidate = m;
                j = m-1; //找到最左
                //i = m + 1; //找到最右
            }
        }
        //return -1;
        return candidate;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,4,4,4,5,6,6,7};
        System.out.println(binarysearchBasic(arr, 6));
    }
}
