package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/10/10 21:37
 * _106InPostOrderTree类
 * 中序和后续遍历生成二叉树
 */
public class _106InPostOrderTree {
    //在后序遍历序列中,最后一个元素为树的根节点
    //在中序遍历序列中,根节点的左边为左子树，根节点的右边为右子树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int root_in_index = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == rootVal) {
                root_in_index = i;
                break;
            }
        }
        int leftTreeLength = root_in_index - iStart;
        root.left = buildTree(inorder,iStart,root_in_index-1,postorder,pStart,pStart+leftTreeLength-1);
        root.right = buildTree(inorder,root_in_index+1,iEnd,postorder,pStart+leftTreeLength,pEnd-1);
        return root;
    }
}
