package tree.offer;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/4 15:52
 * _Of7RebuidTree类
 */
public class _7RebuidTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStar, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for (int i = iStar; i < iEnd; i++) {
            if (rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        //左子树的节点的个数
        int leftTreeNum = rootIndex - iStar;
        root.left = buildTree(preorder,pStart+1,pStart+leftTreeNum+1,
                inorder,iStar,rootIndex);
        root.right = buildTree(preorder,pStart+1+leftTreeNum,pEnd,
                inorder,rootIndex+1,pEnd);
        return root;
    }
}
