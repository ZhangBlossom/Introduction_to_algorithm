package nowcoder.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 张锦标
 * @date: 2023/7/10 9:06
 * RegexSeq类
 */
public class RegexSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            arr[i++] = in.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for (i = 0; i < n; i++) {
            count+=Math.abs(arr[i]-1-i);
        }
        System.out.println(count);
    }
}
