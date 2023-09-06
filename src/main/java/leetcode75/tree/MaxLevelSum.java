package leetcode75.tree;

import offer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 张锦标
 * @date: 2023/9/6 13:04
 * MaxLevelSum类
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int level = 1, maxSum = Integer.MIN_VALUE, maxLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            }
            level++;
        }
        return maxLevel;
    }
}
