package leetcode.tree.offer;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/5 13:34
 * _54KthTopNode类
 * 二叉搜索树的第k大节点
 */
public class _54KthTopNode {

    //  int res, k;
//     public int kthLargest(TreeNode root, int k) {
//         this.k = k;
//         dfs(root);
//         return res;
//     }
//     void dfs(TreeNode root) {
//         if(root == null) return;
//         dfs(root.right);
//         if(k == 0) return;
//         if(--k == 0) res = root.val;
//         dfs(root.left);
//     }


    List<Integer> list = new ArrayList<>();
    // public int kthLargest(TreeNode root, int k) {
    //     if(root==null){
    //         return -1;
    //     }
    //     inorder(root);
    //     return list.get(list.size()-k);
    // }
    // public void inorder(TreeNode root){
    //     if (root==null){
    //         return ;
    //     }
    //     inorder(root.left);
    //     list.add(root.val);
    //     inorder(root.right);
    // }
    //中序遍历得到的是有序的
    //那么中序遍历反过来的操作就是倒序的
    public int kthLargest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        inorder(root);
        return list.get(k-1);
    }

    public void inorder(TreeNode root){
        if (root==null){
            return ;
        }
        inorder(root.right);
        list.add(root.val);
        inorder(root.left);
    }
}
