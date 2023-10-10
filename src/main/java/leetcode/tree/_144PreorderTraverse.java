package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/3 17:36
 * _144PreorderTraverse类
 */
public class _144PreorderTraverse {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
