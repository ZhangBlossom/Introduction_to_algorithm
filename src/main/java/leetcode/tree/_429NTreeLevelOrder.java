package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: 张锦标
 * @date: 2023/10/11 20:03
 * _429NTreeLevelOrder类
 * N叉树的层序遍历
 */
public class _429NTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i =0;i<size;i++){
                Node node = queue.poll();
                list.add(node.val);
                if (node.children!=null){
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
