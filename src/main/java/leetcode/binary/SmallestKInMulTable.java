package leetcode.binary;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/6/26 12:07
 * SmallestKInMulTable类
 */
public class SmallestKInMulTable {
    public int findKthNumber(int m, int n, int k) {
        int len = m * n;
        int[] arr = new int[len];
        int[][] mul = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mul[i][j] = (i + 1) * (j + 1);
                arr[index++] = mul[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}
