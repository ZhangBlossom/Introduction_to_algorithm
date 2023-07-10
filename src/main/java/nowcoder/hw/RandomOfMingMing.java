package nowcoder.hw;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/7/6 19:53
 * RandomOfMingMing类
 * 删除重复并且排序
 * 这道题由于数据量较小
 * 所以可以直接使用计数排序
 */
public class RandomOfMingMing {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[1001];
        int count = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int i = in.nextInt();
            if (arr[i] != 1) {
                count++;
            }
            arr[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
            }
        }

    }
}
