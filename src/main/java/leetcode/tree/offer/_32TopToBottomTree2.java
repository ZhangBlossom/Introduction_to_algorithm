package leetcode.tree.offer;

import leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/4 16:17
 * _Of32TopToBottomTree类
 */
public class _32TopToBottomTree2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root==null){
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            Deque<Integer> level = new LinkedList<>();
            int size = deque.size();
            for(int i = 0;i<size;i++){
                TreeNode node = deque.poll();
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
                level.offer(node.val);
            }
            ans.add(new LinkedList<>(level));
        }
        return ans;
    }
}
