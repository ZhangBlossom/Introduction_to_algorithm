package tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/9/2 20:23
 * _99RecoverBinTree类
 */
public class _99RecoverBinTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        //先对列表进行遍历得到数据
        dfs(root,list);
        //我们知道中序遍历二叉排序树应该是升序的
        TreeNode first = null;
        TreeNode second = null;
        //如果不是升序 那么数据大小不对的两个数就是被交换的两个数
        for(int i=0;i<list.size()-1;i++){
            if (list.get(i).val>list.get(i+1).val){
                //得到后面那个位置不对的数据
                second = list.get(i+1);
                //得到第一个位置不对的数据
                if (first==null){
                    first = list.get(i);
                }
            }
        }
        //交换两个数据
        if (first!=null && second!=null){
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root==null){
            return;
        }
        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);

    }
}
