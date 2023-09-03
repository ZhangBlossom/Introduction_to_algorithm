package tree;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/2 17:20
 * _95DiffBinTree类
 * 给你一个n（数字）
 * 创造一个二叉搜索树
 *
 */
public class _95DiffBinTree {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        //枚举所有根节点
        for (int i = start; i <= end; i++) {
            //获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            //获取所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i+1,end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;

    }
}
