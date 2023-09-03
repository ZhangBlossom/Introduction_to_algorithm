package tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/3 13:08
 * _InPostBuildTree类
 * 根据中序和后序遍历得到一个树
 */
public class _106InPostBuildTree {
    //在后序遍历序列中,最后一个元素为树的根节点
    //在中序遍历序列中,根节点的左边为左子树，根节点的右边为右子树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int root_index = -1;
        //注意这里的条件应该是小于等于
        for (int i = iStart; i <= iEnd; i++) {
            if (rootVal == inorder[i]) {
                root_index = i;
                break;
            }
        }
        int leftTreeNum = root_index-iStart;
        root.left = buildTree(inorder,iStart,root_index-1,
                postorder,pStart,pStart+leftTreeNum-1);
        root.right = buildTree(inorder,root_index+1,iEnd,
                postorder,pStart+leftTreeNum,pEnd-1);
        return root;
    }

}
