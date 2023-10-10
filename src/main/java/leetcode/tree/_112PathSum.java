package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/3 16:29
 * _112PathSum类
 */
public class _112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }

        return findSum(root.left,targetSum-root.val) || findSum(root.right,targetSum-root.val);
    }

    private boolean findSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }   //判断是叶子节点 是叶子节点并且值相同就返回true
        if (root.left==null && root.right==null){
            return root.val==targetSum;
        }else{
            return findSum(root.left,targetSum-root.val)
                    || findSum(root.right,targetSum-root.val);
        }
    }

}
