    package tree.offer;

import leetcode.tree.TreeNode;

import java.util.*;

    /**
 * @author: 张锦标
 * @date: 2023/9/6 9:50
 * _32TopToBottom1类
 */
public class _32TopToBottomTree1 {
        public int[] levelOrder(TreeNode root) {
            if(root == null) {
                return new int[0];
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
            ArrayList<Integer> ans = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            int[] res = new int[ans.size()];
            for(int i = 0; i < ans.size(); i++) {
                res[i] = ans.get(i);
            }
            return res;
        }

}
