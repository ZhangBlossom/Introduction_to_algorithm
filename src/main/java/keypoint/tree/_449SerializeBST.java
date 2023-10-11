package keypoint.tree;

import leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/10/11 20:19
 * _449SerializeBST类
 */
public class _449SerializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        //去掉末尾，
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }
    public void dfs(TreeNode root,StringBuilder sb){
        if (root==null){
            return ;
        }
        sb.append(root.val).append(",");
        if (root.left!=null){
            dfs(root.left,sb);
        }else{
            sb.append("#").append(",");
        }

        if (root.right!=null){
            dfs(root.right,sb);
        }else{
            sb.append("#").append(",");
        }

    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    //这里其实就变为了假设用户进行数据输入
    //如何构造一个二叉树
    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("#")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
}
