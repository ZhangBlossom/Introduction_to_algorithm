package leetcode.recall.middle;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/6/18 21:33
 * FullPermutation2类
 */
public class FullPermutation2 {
    static boolean[] vis;
    public static List<List<Integer>> permuteUnique1(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        recall(set,list,visited,nums);
        return new ArrayList<List<Integer>>(set) ;
    }
    public static void recall(Set<List<Integer>> set,List<Integer> list,int[] visited,int[] nums){
        if (list.size()==nums.length){
            set.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (visited[i]==1){
                continue;
            }
            visited[i]=1;
            list.add(nums[i]);
            recall(set,list,visited,nums);
            visited[i]=0;
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }


    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
    }
}
