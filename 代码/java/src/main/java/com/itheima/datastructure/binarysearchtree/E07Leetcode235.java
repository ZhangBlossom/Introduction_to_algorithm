package com.itheima.datastructure.binarysearchtree;

/**
 * 求二叉搜索树最近公共祖先(祖先也包括自己)
 * <br>
 * 前提
 * <ol>
 *     <li>节点值唯一</li>
 *     <li>p 和 q 都存在</li>
 * </ol>
 */
public class E07Leetcode235 {
    /*
            __ 6 __
           /       \
          2         8
         / \       / \
        0   4     7   9
           / \
          3   5

          待查找节点 p q 在某一节点的两侧，那么此节点就是最近的公共祖先
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while (p.val < a.val && q.val < a.val || a.val < p.val && a.val < q.val) { // 在同一侧
            if (p.val < a.val) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        TreeNode t1 = new E07Leetcode235().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(t1.val); // 应为 6
        TreeNode t2 = new E07Leetcode235().lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5));
        System.out.println(t2.val); // 应为 4
    }
}
