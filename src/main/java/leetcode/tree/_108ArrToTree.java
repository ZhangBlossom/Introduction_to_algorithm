package leetcode.tree;

/**
 * @author: 张锦标
 * @date: 2023/9/3 14:19
 * _108ArrToTree类
 * BST二叉搜索树
 * BST 的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
 * 因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，
 * 以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～
 * 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥～
 *
 */
public class _108ArrToTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    private TreeNode dfs(int[] nums, int low, int high) {
        if (low>high){
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,low,mid-1);
        root.right = dfs(nums,mid+1,high);
        return root;
    }
}
