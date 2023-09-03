package tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/2 20:59
 * _102FloorTraverse类
 */
public class _102FloorTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            //只是为了得到当前层的节点的个数
            int n = deque.size();
            List<Integer> floor = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.poll();
                //如果左右节点非空那么就放入
                //这些左右节点都是下一层的数据
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                //添加到当前层
                floor.add(node.val);
            }
            //添加当前层
            list.add(floor);
        }
        return list;
    }
}
