package tree;

/**
 * @author: 张锦标
 * @date: 2023/9/3 19:24
 * Demo类
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int count = find(arr);
        System.out.println(count);
    }

    private static int find(int[] arr) {
        int maxLen = 0;
        int start = 0;
        Set<Integer> set = new HashSet<>();
        for (int end = 0; end < arr.length; end++) {
            int flavor = arr[end];
            while (set.contains(flavor)) {
                set.remove(arr[start]);
                start++;
            }
            set.add(flavor);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
