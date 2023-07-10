package nowcoder.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 张锦标
 * @date: 2023/7/10 8:51
 * EliminationScore类
 */
public class EliminationScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            arr[i++] = in.nextInt();
        }
        Arrays.sort(arr);
        int value = n - y;
        //n-y>y;比如10个人，[2,4];10-4>4;说明不管怎么分都不可能使得淘汰的和通过的人数都在区间[2,4];
        if (value > y) {
            System.out.println(-1);
            //n-y在区间[x,y];比如7个人，[2,4];7-4=3;
            // 则返回第三个位置的人的分数 因为数组下标从0开始,所以第三个位置下标是2也就是value-1
        } else if (value >= x && value <= y) {
            System.out.println(arr[value - 1]);
            //n-y<x;比如3个人，[2,4];3-4=-1; 返回分数第x位置的人的分数 同上
        } else {
            System.out.println(arr[x - 1]);
        }

    }
}
