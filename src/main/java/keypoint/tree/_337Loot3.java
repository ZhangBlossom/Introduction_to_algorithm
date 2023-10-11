package keypoint.tree;

import leetcode.tree.TreeNode;
import leetcode.tree._RightView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/10/11 19:33
 * _337Loot3类
 * 打家劫舍3
 * https://leetcode.cn/problems/house-robber-iii/solutions/361038/da-jia-jie-she-iii-by-leetcode-solution/
 */
public class _337Loot3 {
    //表示选当前点之后的收益
    Map<TreeNode,Integer> choose = new HashMap<>();
    //表示不收当前点的收益
    Map<TreeNode,Integer> noChoose = new HashMap<>();
    public int rob(TreeNode root){
        dfs(root);
        return Math.max(noChoose.getOrDefault(root,0),choose.getOrDefault(root,0));
    }

    public void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        //采用后续遍历的方式得到节点的值比较合理
        dfs(root.left);
        dfs(root.right);
        choose.put(root,root.val+noChoose.getOrDefault(root.left,0)+noChoose.getOrDefault(root.right,0));
        noChoose.put(root,Math.max(choose.getOrDefault(root.left,0),noChoose.getOrDefault(root.left,0))+
                Math.max(choose.getOrDefault(root.right,0),noChoose.getOrDefault(root.right,0)));
    }
}
