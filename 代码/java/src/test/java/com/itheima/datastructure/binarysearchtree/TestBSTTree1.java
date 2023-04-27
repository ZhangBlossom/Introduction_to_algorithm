package com.itheima.datastructure.binarysearchtree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBSTTree1 {

    public BSTTree1 createTree() {
        /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, "张无忌");
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, "宋青书");
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, "周芷若", n1, n3);

        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, "说不得");
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, "殷离");
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, "赵敏", n5, n7);
        BSTTree1.BSTNode root = new BSTTree1.BSTNode(4, "小昭", n2, n6);

        BSTTree1 tree = new BSTTree1();
        tree.root = root;
        return tree;
    }

    @Test
    void get() {
        BSTTree1 tree = createTree();
        assertEquals("张无忌", tree.get(1));
        assertEquals("周芷若", tree.get(2));
        assertEquals("宋青书", tree.get(3));
        assertEquals("小昭", tree.get(4));
        assertEquals("说不得", tree.get(5));
        assertEquals("赵敏", tree.get(6));
        assertEquals("殷离", tree.get(7));
        assertNull(tree.get(8));
    }

    @Test
    public void minMax() {
        BSTTree1 tree = createTree();
        assertEquals("张无忌", tree.min());
        assertEquals("殷离", tree.max());
    }

    @Test
    public void put() {
        BSTTree1 tree = new BSTTree1();
        tree.put(4, new Object());
        tree.put(2, new Object());
        tree.put(6, new Object());
        tree.put(1, new Object());
        tree.put(3, new Object());
        tree.put(7, new Object());
        tree.put(5, new Object());
        assertTrue(isSameTree(createTree().root, tree.root));
        tree.put(1, "教主张无忌");
        assertEquals("教主张无忌", tree.get(1));
    }

    static boolean isSameTree(BSTTree1.BSTNode tree1, BSTTree1.BSTNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.key != tree2.key) {
            return false;
        }
        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }

    @Test
    public void predecessor() {
        /*
                     4
                   /   \
                  2     7
                 / \   / \
                1   3 6   8
                     /
                    5
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, 5);
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6, n5, null);
        BSTTree1.BSTNode n8 = new BSTTree1.BSTNode(8, 8);
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, 7, n6, n8);
        BSTTree1.BSTNode root = new BSTTree1.BSTNode(4, 4, n2, n7);

        BSTTree1 tree = new BSTTree1();
        tree.root = root;

        assertNull(tree.predecessor(1));
        assertEquals(1, tree.predecessor(2));
        assertEquals(2, tree.predecessor(3));
        assertEquals(3, tree.predecessor(4));
        assertEquals(4, tree.predecessor(5));
        assertEquals(5, tree.predecessor(6));
        assertEquals(6, tree.predecessor(7));
        assertEquals(7, tree.predecessor(8));
    }

    @Test
    public void successor() {
        /*
                     5
                   /   \
                  2     7
                 / \   / \
                1   3 6   8
                     \
                      4
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n4 = new BSTTree1.BSTNode(4, 4);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3, null, n4);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6);
        BSTTree1.BSTNode n8 = new BSTTree1.BSTNode(8, 8);
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, 7, n6, n8);
        BSTTree1.BSTNode root = new BSTTree1.BSTNode(5, 5, n2, n7);

        BSTTree1 tree = new BSTTree1();
        tree.root = root;

        assertEquals(2, tree.successor(1));
        assertEquals(3, tree.successor(2));
        assertEquals(4, tree.successor(3));
        assertEquals(5, tree.successor(4));
        assertEquals(6, tree.successor(5));
        assertEquals(7, tree.successor(6));
        assertEquals(8, tree.successor(7));
        assertNull(tree.successor(8));
    }

    @Test
    @DisplayName("删除叶子节点")
    public void delete1() {
        /*
                     4
                   /   \
                  2     7
                 / \   / \
                1   3 6   8
                     /
                    5
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, 5);
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6, n5, null);
        BSTTree1.BSTNode n8 = new BSTTree1.BSTNode(8, 8);
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, 7, n6, n8);
        BSTTree1.BSTNode root1 = new BSTTree1.BSTNode(4, 4, n2, n7);

        BSTTree1 tree1 = new BSTTree1();
        tree1.root = root1;

        assertEquals(1, tree1.remove(1));
        assertEquals(3, tree1.remove(3));
        assertEquals(5, tree1.remove(5));
        assertEquals(8, tree1.remove(8));


        /*
                     4
                   /   \
                  2     7
                       /
                      6
         */
        BSTTree1.BSTNode x2 = new BSTTree1.BSTNode(2, 2);
        BSTTree1.BSTNode x6 = new BSTTree1.BSTNode(6, 6);
        BSTTree1.BSTNode x7 = new BSTTree1.BSTNode(7, 7, x6, null);
        BSTTree1.BSTNode root2 = new BSTTree1.BSTNode(4, 4, x2, x7);
        BSTTree1 tree2 = new BSTTree1();
        tree2.root = root2;

        assertTrue(isSameTree(tree1.root, tree2.root));
    }

    @Test
    @DisplayName("删除只有一个孩子节点")
    public void delete2() {
        /*
                     4
                   /   \
                  2     7
                 / \   /
                1   3 6
                     /
                    5
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, 5);
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6, n5, null);
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, 7, n6, null);
        BSTTree1.BSTNode root1 = new BSTTree1.BSTNode(4, 4, n2, n7);

        BSTTree1 tree1 = new BSTTree1();
        tree1.root = root1;

        assertEquals(7, tree1.remove(7));


        /*
                     4
                   /   \
                  2     6
                 / \   /
                1   3 5
         */
        BSTTree1.BSTNode x1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode x3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode x2 = new BSTTree1.BSTNode(2, 2, x1, x3);
        BSTTree1.BSTNode x5 = new BSTTree1.BSTNode(5, 5);
        BSTTree1.BSTNode x6 = new BSTTree1.BSTNode(6, 6, x5, null);
        BSTTree1.BSTNode root2 = new BSTTree1.BSTNode(4, 4, x2, x6);
        BSTTree1 tree2 = new BSTTree1();
        tree2.root = root2;

        assertTrue(isSameTree(tree1.root, tree2.root));
    }

    @Test
    @DisplayName("删除有两个孩子节点, 被删除与后继不邻")
    public void delete3() {
        /*
                      4
                   /     \
                  2      7
                 / \   /   \
                1   3 5     8
                       \
                        6
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6);
        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, 5, null, n6);
        BSTTree1.BSTNode n8 = new BSTTree1.BSTNode(8, 8);
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, 7, n5, n8);
        BSTTree1.BSTNode root1 = new BSTTree1.BSTNode(4, 4, n2, n7);

        BSTTree1 tree1 = new BSTTree1();
        tree1.root = root1;

        assertEquals(4, tree1.remove(4));


        /*
                      5
                   /     \
                  2      7
                 / \   /   \
                1   3 6     8

         */
        BSTTree1.BSTNode x1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode x3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode x2 = new BSTTree1.BSTNode(2, 2, x1, x3);

        BSTTree1.BSTNode x6 = new BSTTree1.BSTNode(6, 6);
        BSTTree1.BSTNode x8 = new BSTTree1.BSTNode(8, 8);
        BSTTree1.BSTNode x7 = new BSTTree1.BSTNode(7, 7, x6, x8);
        BSTTree1.BSTNode root2 = new BSTTree1.BSTNode(5, 5, x2, x7);
        BSTTree1 tree2 = new BSTTree1();
        tree2.root = root2;

        assertTrue(isSameTree(tree1.root, tree2.root));
    }

    @Test
    @DisplayName("删除有两个孩子节点, 被删除与后继相邻")
    public void delete4() {
        /*
                     4
                   /   \
                  2     5
                 / \     \
                1   3     6

         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6);
        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, 5, null, n6);
        BSTTree1.BSTNode root1 = new BSTTree1.BSTNode(4, 4, n2, n5);

        BSTTree1 tree1 = new BSTTree1();
        tree1.root = root1;

        assertEquals(4, tree1.remove(4));


        /*
                     5
                   /  \
                  2    6
                 / \
                1   3

         */
        BSTTree1.BSTNode x1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode x3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode x2 = new BSTTree1.BSTNode(2, 2, x1, x3);

        BSTTree1.BSTNode x6 = new BSTTree1.BSTNode(6, 6);
        BSTTree1.BSTNode root2 = new BSTTree1.BSTNode(5, 5, x2, x6);
        BSTTree1 tree2 = new BSTTree1();
        tree2.root = root2;

        assertTrue(isSameTree(tree1.root, tree2.root));
    }

    @Test
    public void less() {
        /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
         */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, 1);
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, 3);
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, 2, n1, n3);

        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, 5);
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, 7);
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, 6, n5, n7);
        BSTTree1.BSTNode root = new BSTTree1.BSTNode(4, 4, n2, n6);

        BSTTree1 tree = new BSTTree1();
        tree.root = root;

        assertIterableEquals(List.of(1, 2, 3, 4, 5), tree.less(6));
        assertIterableEquals(List.of(7), tree.greater(6));
        assertIterableEquals(List.of(3, 4, 5), tree.between(3, 5));
//          tree.greater(6);
    }
}