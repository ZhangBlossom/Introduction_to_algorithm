package offer.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/7/4 19:55
 * PathSum3类
 */
public class PathSum3 {
    //public int pathSum(TreeNode root, int targetSum) {
    //    if (root == null) {
    //        return 0;
    //    }
    //
    //    int ret = rootSum(root, targetSum);
    //    ret += pathSum(root.left, targetSum);
    //    ret += pathSum(root.right, targetSum);
    //    return ret;
    //}
    //
    //public int rootSum(TreeNode root, long targetSum) {
    //    int ret = 0;
    //
    //    if (root == null) {
    //        return 0;
    //    }
    //    int val = root.val;
    //    if (val == targetSum) {
    //        ret++;
    //    }
    //
    //    ret += rootSum(root.left, targetSum - val);
    //    ret += rootSum(root.right, targetSum - val);
    //    return ret;
    //}


    //public int pathSum(TreeNode root, int targetSum) {
    //    if (root == null) {
    //        return 0;
    //    }
    //
    //    int ret = rootSum(root, targetSum, 0L);
    //    ret += pathSum(root.left, targetSum);
    //    ret += pathSum(root.right, targetSum);
    //    return ret;
    //}
    //
    //public int rootSum(TreeNode root, long targetSum, long curSum) {
    //    int ret = 0;
    //
    //    if (root == null) {
    //        return 0;
    //    }
    //    int val = root.val;
    //    if (val+curSum == targetSum) {
    //        ret++;
    //    }
    //
    //    ret += rootSum(root.left, targetSum,val+curSum);
    //    ret += rootSum(root.right, targetSum,val+curSum);
    //    return ret;
    //}

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        rootSum(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count ;
    }

    public void rootSum(TreeNode root, long targetSum, long curSum) {
        if (root==null){
            return ;
        }
        int val = root.val;
        if (curSum+val==targetSum){
            count++;
        }
        rootSum(root.left,targetSum,curSum+val);
        rootSum(root.right,targetSum,curSum+val);
    }

}
