package tree;

import common.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 张锦标
 * @date: 2023/9/3 18:31
 * _117FillRightNode类
 */
public class _117FillRightNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            //前置节点
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return root;
    }

}

