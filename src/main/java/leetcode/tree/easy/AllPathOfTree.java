package leetcode.tree.easy;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/10 11:58
 * AllPathOfTree类
 */
public class AllPathOfTree {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        //如果为空，直接返回
        if (root == null) {
            return;
        }
        //如果是叶子节点，说明找到了一条路径，把它加入到res中
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        //如果不是叶子节点，在分别遍历他的左右子节点
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }


    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>(2);
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(root.val);
        right.add(root.val);
        inorderTraversal(root.left, left);
        inorderTraversal(root.right, right);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < left.size() && left.size() > 1; i++) {
            sb.append(left.get(i) + "->");
        }
        if (sb.length() > 1) {

            result.add(sb.toString().substring(0, sb.length() - 2));
        }
        sb = new StringBuilder();

        for (int i = 0; i < right.size() && right.size() > 1; i++) {
            sb.append(right.get(i) + "->");
        }
        if (sb.length() > 1) {
            result.add(sb.toString().substring(0, sb.length() - 2));
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = null;
        System.out.println(binaryTreePaths1(root));
    }
}
