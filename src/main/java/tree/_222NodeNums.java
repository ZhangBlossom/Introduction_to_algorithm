package tree;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/5 16:06
 * _222NodeNums类
 */
public class _222NodeNums {
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
}
