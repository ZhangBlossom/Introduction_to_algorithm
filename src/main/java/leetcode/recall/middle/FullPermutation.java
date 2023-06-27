package leetcode.recall.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/18 15:05
 * FullPermutation类
 * 全排列 46
 */
public class FullPermutation {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        //for (int num : nums) {
        //    output.add(num);
        //}
        //backtrack2(nums.length,output,res,0);
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static  void backtrack2(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack2(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }



    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
