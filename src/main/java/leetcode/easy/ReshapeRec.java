package leetcode.easy;

/**
 * @author: 张锦标
 * @date: 2023/2/23 14:53
 * Description:
 */
public class ReshapeRec {

            public int[][] matrixReshape(int[][] nums, int r, int c) {
                int m = nums.length;
                int n = nums[0].length;
                if (m * n != r * c) {
                    return nums;
                }

                int[][] ans = new int[r][c];
                for (int x = 0; x < m * n; ++x) {
                    ans[x / c][x % c] = nums[x / n][x % n];
                }
                return ans;
            }




}
