package leetcode.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else if (root.val < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public void inorderTraverse(TreeNode root){
        if (root==null){
            return ;
        }
        inorderTraverse(root.left);
        inorderTraverse(root.right);
        System.out.println(root.val);
    }
}
