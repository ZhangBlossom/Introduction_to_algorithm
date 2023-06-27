package leetcode.easy.tree;

import java.util.*;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/26 16:01
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 102
 * 二叉树的层序遍历
 */
public class TreeFloor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> floor = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                floor.add(node.val);
            }
            list.add(floor);
        }
        return list;
    }



    public static void main(String[] args) {

    }
}
