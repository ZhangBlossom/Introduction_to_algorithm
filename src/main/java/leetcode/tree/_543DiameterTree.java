package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/4 14:52
 * _543DiameterTree类
 */
public class _543DiameterTree {
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxD;
    }
    //只要计算出来左右子树的最大深度即可
    //然后两个深度相加就是最大的直径
    private int depth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        maxD = Math.max(left+right,maxD);
        return Math.max(left,right)+1;
    }
}
