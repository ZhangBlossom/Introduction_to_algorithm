package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/3 17:17
 * _114TreeToList类
 */
public class _114TreeToList {
    //最简单的做法 直接前序遍历得到所有节点
    //然后直接放到右子树去
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root,list);
        int size = list.size();
        for(int i = 1;i<size;i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
