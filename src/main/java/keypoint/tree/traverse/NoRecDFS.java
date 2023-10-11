package keypoint.tree.traverse;

import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/10/11 17:17
 * NoRecDFS类
 */
public class NoRecDFS {
    public void noRecDFS(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }
}
