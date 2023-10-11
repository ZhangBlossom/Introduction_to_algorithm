package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/10/11 11:28
 * _BTPath类
 */
public class _257BTPath {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, new ArrayList<>());
        return res;
    }

    //当前方法用于得到从根节点到达所有叶子节点的所有路径上的数据
    public void dfs(TreeNode root, List<String> paths) {
        if (root == null) {
            return;
        }
        paths.add(root.val + "");
        if (root.left == null && root.right == null) {
            res.add(String.join("->", paths));
        }
        dfs(root.left, paths);
        dfs(root.right, paths);
        paths.remove(paths.size() - 1);
    }

}
