package tree.recite;

import offer.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/9/5 16:10
 * _129TopToLeafSum类
 */
public class _129TopToLeafSum {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int curSum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        } else {
            return dfs(root.left, curSum) + dfs(root.right, curSum);
        }
    }

    public static void main(String[] args) {
        int count = 0;
        for(int i = 0;i < 100;i++)
        {
            count = count++;
        }
        System.out.println("count = "+count);

    }
}
