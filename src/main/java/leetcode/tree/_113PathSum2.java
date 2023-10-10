package leetcode.tree;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/9/3 16:29
 * _112PathSum类
 */
public class _113PathSum2 {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            findSum(root,targetSum);
            return list;
    }

    private void findSum(TreeNode root, int targetSum) {
        if (root==null){
            return;
        }
        path.offerLast(root.val);
        targetSum-=root.val;
        if (root.left==null && root.right==null && targetSum==0){
            list.add(new LinkedList<>(path));
        }
        findSum(root.left,targetSum);
        findSum(root.right,targetSum);
        path.pollLast();
    }

}
