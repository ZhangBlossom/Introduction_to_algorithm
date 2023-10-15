package type.devide_and_conquer;

/**
 * @author: 张锦标
 * @date: 2023/10/15 13:53
 * SmallSumQuestion类
 * 小和问题
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子:[1,3,4,2,5]1左边比1小的数，没有;3左边比3小的数，1;4左边比4小的数，
 * 1、3;2左边比2小的数，1;5左边比5小的数，1、3、4、2;所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSumQuestion {
    public static int smallSum(int[] arr, int left, int right) {
        if (right==left) {
            return 0;
        }
        int mid = ((right - left) >> 1) + left;
        int leftSum = smallSum(arr, left, mid); //左边小和
        int rightSum = smallSum(arr, mid + 1, right); //右边小和
        return leftSum + rightSum + process(arr, left, mid, right);//左右相加加上总体的小和数量
    }

    public static int process(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1];
                res += (right-p2 + 1) * arr[p1];
                p1++;
            } else {
                help[i++] = arr[p2];
                p2++;
            }
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=right){
            help[i++] = arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[left+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }
}
