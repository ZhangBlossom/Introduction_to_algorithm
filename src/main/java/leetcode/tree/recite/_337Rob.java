package leetcode.tree.recite;

import leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/9/6 9:53
 * _337Rob类
 */
public class _337Rob {
    //这种做法是超时的 但是确实最好理解也最简单
    //这种做法的思路就是 分为爷爷、儿子、孙子
    //就是判断爷爷+孙子得到的钱和儿子得到的钱谁更多
    //这里爷爷就是root一开始
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //选择根节点的钱
        int money = root.val;
        //如果左右子树不为空 那么选择左右节点的子节点的值
        //判断最多四个孙子能拿多少钱
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }
        //比较根节点和间隙节点的值 和 根节点的两个子节点的值 谁更大
        return Math.max(money, rob(root.left) + rob(root.right));
    }
    /////-----------------------顶级做法-----------
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob1(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
