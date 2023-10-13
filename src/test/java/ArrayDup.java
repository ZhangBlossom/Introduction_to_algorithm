import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/12 20:08
 * ArrayDup类
 */
public class ArrayDup {
    public static void removeDupArray(int[] arr){
        if (arr==null){
            return ;
        }
        TreeNode root = new TreeNode(arr[0]);
        for(int i =1;i<arr.length;i++){
            root.insert(root,arr[i]);
        }
        root.inorderTraverse(root);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4};
        removeDupArray(arr);
    }
}
