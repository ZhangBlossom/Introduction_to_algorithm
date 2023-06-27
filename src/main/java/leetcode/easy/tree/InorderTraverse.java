package leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/27 8:22
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 94
 */
public class InorderTraverse {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorderTraversal(root, list);
    }

    public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }

    public static void main(String[] args) {

    }
}
