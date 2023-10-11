package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/10/11 18:05
 * _297SerializeTree类
 * 当前方法用于给定你一个二叉树
 * 然后通过自己的方法实现对二叉树的序列化和反序列化
 *
 */
public class _297SerializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
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
            sb.append("#").append(",");
        }else{
            dfs(root.left,sb);
        }

        if (root.right!=null){
            sb.append("#").append(",");
        }else{
            dfs(root.right,sb);
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
