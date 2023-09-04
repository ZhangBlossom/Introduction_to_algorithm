package tree.offer;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/4 16:25
 * _26TreeSonStructure类
 * 树的子结构
 */
public class _26TreeSonStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
