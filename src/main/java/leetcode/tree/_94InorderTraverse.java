package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/2 17:25
 * _94InorderTraverse类
 * 中序遍历二叉搜索树
 * 得到的集合应该是升序的
 */
public class _94InorderTraverse {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recall(root);
        return list;
    }
    public void recall(TreeNode root){
        if(root==null){
            return;
        }
        recall(root.left);
        list.add(root.val);
        recall(root.right);

    }
}
