package tree;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/5 13:49
 * _230KthSmallestNode类
 */
public class _230KthSmallestNode {
    int res,k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        find(root);
        return res;
    }

    private void find(TreeNode root) {
        if (root==null){
            return;
        }
        find(root.left);
        if (--k==0){
            this.res = root.val;
        }
        if (k==0){
            return;
        }
        find(root.right);
    }
}
