package keypoint.tree;

import leetcode.tree.TreeNode;

/**
 * @author: 张锦标
 * @date: 2023/10/11 20:30
 * _450DeleteNode类
 */
public class _450DeleteNode {
    /*
    如果目标节点大于当前节点值，则去右子树中删除；
    如果目标节点小于当前节点值，则去左子树中删除；
    如果目标节点就是当前节点，分为以下三种情况：
    其无左子：其右子顶替其位置，删除了该节点；
    其无右子：其左子顶替其位置，删除了该节点；
    其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，
    然后右子树顶替其位置，由此删除了该节点。
            */
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            //根据二叉搜索树 其有序
            if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {//要删除的节点就是根节点
                //根节点没有左子树
                if (root.left == null) {
                    //返回右子树
                    return root.right;
                }
                //根节点没有右子树
                if (root.right == null) {
                    //返回左子树
                    return root.left;
                }
                //左右节点都有
                //那么要让右子树的最左子树的下一个节点变为原本的左子树
                TreeNode node = root.right;
                //找到右子树的最左节点
                while (node.left != null) {
                    node = node.left;
                }
                //让这个最左节点的左子树变为原本根节点的左子树
                node.left = root.left;
                //让根节点变为原有跟子树的右节点
                root = root.right;
            }
            //返回根节点
            return root;
        }
    }
