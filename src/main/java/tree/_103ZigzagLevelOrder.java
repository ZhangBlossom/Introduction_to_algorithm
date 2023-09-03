package tree;

import leetcode.tree.TreeNode;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/9/2 21:10
 * _103ZigzagLevelOrder类
 */
public class _103ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int n = deque.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (flag) {
                    //这里由于我们是先放入左节点
                    //所以我们后面为了顺序 应该addLast
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }
            }
            flag = !flag;
            list.add(new LinkedList<>(levelList));
        }
        return list;
    }
}
