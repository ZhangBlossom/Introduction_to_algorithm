package tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/3 11:04
 * _105PreInBuildTree类
 * 使用前序和中序遍历构造二叉树
 */

public class _105PreInBuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int root_in_index = 0;
        //中序遍历中第一次等于根节点的值就是左子树
        for (int i = iStart; i < iEnd; i++) {
            //得到中序遍历中根节点的位置
            if (inorder[i] == rootVal) {
                root_in_index = i;
                break;
            }
        }
        //得到左子树的长度
        int leftTreeLength = root_in_index - iStart;
        //构建左右子树
        //这里是一个左闭右开的区间
        //也就是Start都是被包含的 但是End是结束的位置 不被包含
        root.left = buildTree(preorder, pStart + 1, pStart + 1 + leftTreeLength, inorder, iStart, root_in_index);
        root.right = buildTree(preorder, pStart + 1 + leftTreeLength, pEnd, inorder, root_in_index + 1, iEnd);
        return root;
    }
}
