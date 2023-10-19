package datastructure.tree;

import leetcode.tree.TreeNode;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/10/19 13:20
 * FloorTraverse类
 */
public class FloorTraverse {
    public static void floorTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                System.out.println(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    /**
     * 记录当前节点的层
     *
     * @param head
     */
    public static void floorTraverseRecordLevel(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> floorMap = new HashMap<>();
        queue.offer(head);
        floorMap.put(head, 1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int curFloor = floorMap.get(node);
                if (node.left != null) {
                    floorMap.put(node.left, curFloor + 1);
                    queue.add(node.left);
                }
                System.out.println(node.val);
                if (node.right != null) {
                    floorMap.put(node.right, curFloor + 1);
                    queue.add(node.right);
                }
            }
        }
        System.out.println(floorMap);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        floorTraverseRecordLevel(head);
    }
}
