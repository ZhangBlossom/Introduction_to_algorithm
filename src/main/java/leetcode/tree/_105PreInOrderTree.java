package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/10/10 21:04
 * _105PreInOrderTree类
 * 根据前序和中序遍历的结果构造一个二叉树
 */
public class _105PreInOrderTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        //在前序遍历中 根节点就是数组下标第一个的元素
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        //中序遍历中根节点的位置是
        int root_in_index = 0;
        for (int i = 0; i < iEnd; i++) {
            if (inorder[i] == rootVal) {
                root_in_index = i;
                break;
            }
        }
        //得到左子树的长度
        int leftTreeLength = root_in_index - iStart;
        //构建左右子树 前闭后开区间
        root.left = buildTree(preorder, pStart + 1, pStart + 1 + leftTreeLength, inorder, iStart, root_in_index);
        root.right = buildTree(preorder, pStart + 1 + leftTreeLength, pEnd, inorder, root_in_index + 1, iEnd);
        return root;
    }
}
