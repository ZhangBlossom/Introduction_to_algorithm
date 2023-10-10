package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/2 20:43
 * _100SameTree类
 */
public class _100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val!=q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left) &&
                    isSameTree(p.right,q.right);
        }
    }
}
