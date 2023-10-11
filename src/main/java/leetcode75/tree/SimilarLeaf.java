package leetcode75.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/6 10:47
 * SimilarLeaf类
 * 判断两棵树的叶子节点是否相等
 */
public class SimilarLeaf {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeafNode(root1, list1);
        getLeafNode(root2, list2);
        return list1.equals(list2);
    }

    public void getLeafNode(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            list.add(root.val);
        } else {
            getLeafNode(root.left, list);
            getLeafNode(root.right, list);
        }
    }

    public boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
