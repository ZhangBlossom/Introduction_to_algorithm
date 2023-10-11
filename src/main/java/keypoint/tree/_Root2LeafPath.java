package keypoint.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/10/11 11:52
 * _Root2LeafPath类
 */
public class _Root2LeafPath {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(root, new ArrayList<>());
        return list;
    }

    //当前方法用于得到从根节点到达所有叶子节点的所有路径上的数据
    public void dfs(TreeNode root, List<Integer> ls) {
        if (root == null) {
            return;
        }
        ls.add(root.val);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(ls));
        }
        dfs(root.left, ls);
        dfs(root.right, ls);
        ls.remove(ls.size() - 1);
    }

}
