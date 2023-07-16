package offer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/7/16 10:27
 * TreeRightView类
 */
public class TreeRightView {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode root,int depth){
        if (root == null){
            return;
        }
        if (depth == res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}
