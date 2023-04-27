package com.itheima.algorithm.btree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBTree {

    @Test
    @DisplayName("split(t=2)")
    void split1() {
        /*
                5               2|5
              /   \     ==>    / | \
           1|2|3   6          1  3  6

         */
        BTree tree = new BTree();
        BTree.Node root = tree.root;
        root.leaf = false;
        root.keys[0] = 5;
        root.keyNumber = 1;

        root.children[0] = new BTree.Node(new int[]{1, 2, 3});
        root.children[0].keyNumber = 3;

        root.children[1] = new BTree.Node(new int[]{6});
        root.children[1].keyNumber = 1;

        tree.split(root.children[0], root, 0);
        assertEquals("[2, 5]", root.toString());
        assertEquals("[1]", root.children[0].toString());
        assertEquals("[3]", root.children[1].toString());
        assertEquals("[6]", root.children[2].toString());
    }

    @Test
    @DisplayName("split(t=3)")
    void split2() {
        /*
                  6                 3|6
               /     \     ==>    /  |  \
           1|2|3|4|5  7         1|2 4|5  7

         */
        BTree tree = new BTree(3);
        BTree.Node root = tree.root;
        root.leaf = false;
        root.keys[0] = 6;
        root.keyNumber = 1;
        root.children[0] = new BTree.Node(new int[]{1, 2, 3, 4, 5});
        root.children[0].keyNumber = 5;

        root.children[1] = new BTree.Node(new int[]{7});
        root.children[1].keyNumber = 1;

        tree.split(root.children[0], root, 0);
        assertEquals("[3, 6]", root.toString());
        assertEquals("[1, 2]", root.children[0].toString());
        assertEquals("[4, 5]", root.children[1].toString());
        assertEquals("[7]", root.children[2].toString());
    }

    @Test
    public void insert() {
        BTree tree = new BTree();
        tree.put(1);
        tree.put(3);
        tree.put(2);
    }

    @Test
    @DisplayName("put(t=2)")
    void testPut1() {
        /*
                                  2
                                 / \
              1|2|3       =>    1   3

                2                2|4
               / \        =>    / | \
              1 3|4|5          1  3  5
                                                    4
                2|4             2|4|6              / \
               / | \      =>   / / \ \     =>     2   6
              1  3 5|6|7      1  3  5 7          / \ / \
                                                1  3 5  7

                4                 4
               / \              /   \
              2   6      =>    2    6|8
             /\  / \          /\   / | \
            1  3 5 7|8|9     1  3 5  7  9

                 4                   4                   4|8
               /   \               /   \                / | \
              2    6|8      =>    2    6|8|10      =>  2  6  10
             /\   / | \          /\   / / \ \         /\  /\  /\
            1  3 5  7 9|10|11   1  3 5 7  9  11      1 3 5 7 9 11
        */
        BTree tree = new BTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.put(8);
        tree.put(9);
        tree.put(10);
        tree.put(11);
        assertEquals("[4, 8]", tree.root.toString());
        assertEquals("[2]", tree.root.children[0].toString());
        assertEquals("[6]", tree.root.children[1].toString());
        assertEquals("[10]", tree.root.children[2].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[5]", tree.root.children[1].children[0].toString());
        assertEquals("[7]", tree.root.children[1].children[1].toString());
        assertEquals("[9]", tree.root.children[2].children[0].toString());
        assertEquals("[11]", tree.root.children[2].children[1].toString());
    }

    @Test
    @DisplayName("put(t=3)")
    void testPut2() {
        /*
                 3
               /   \
             1|2  4|5|6|7
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        assertEquals("[3]", tree.root.toString());
        assertEquals("[1, 2]", tree.root.children[0].toString());
        assertEquals("[4, 5, 6, 7]", tree.root.children[1].toString());
    }

    @Test
    void testSearch() {
        BTree tree = new BTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.put(8);
        tree.put(9);
        tree.put(10);
        assertEquals(tree.root, tree.root.get(4));
        assertEquals(tree.root.children[0], tree.root.get(2));
        assertEquals(tree.root.children[0].children[0], tree.root.get(1));
        assertEquals(tree.root.children[0].children[1], tree.root.get(3));
        assertEquals(tree.root.children[1], tree.root.get(6));
        assertEquals(tree.root.children[1], tree.root.get(8));
        assertEquals(tree.root.children[1].children[0], tree.root.get(5));
        assertEquals(tree.root.children[1].children[1], tree.root.get(7));
        assertEquals(tree.root.children[1].children[2], tree.root.get(9));
        assertEquals(tree.root.children[1].children[2], tree.root.get(10));
        assertNull(tree.root.get(11));
    }

    @Test
    void testPut3() {
        BTree tree = new BTree();
        tree.put(6);
        tree.put(3);
        tree.put(8);
        tree.put(1);
        tree.put(2);
        tree.put(5);
        tree.put(4);
        assertEquals("[4]", tree.root.toString());
        assertEquals("[2]", tree.root.children[0].toString());
        assertEquals("[6]", tree.root.children[1].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[5]", tree.root.children[1].children[0].toString());
        assertEquals("[8]", tree.root.children[1].children[1].toString());
    }

    @Test
    @DisplayName("case1: leaf && not found")
    public void testRemove0() {
        /*
             1|2|3|4
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);

        tree.remove(0);
        tree.remove(8);
        assertEquals("[1, 2, 3, 4]", tree.root.toString());
    }

    @Test
    @DisplayName("case3: non-leaf && not found")
    public void testRemove1() {
        /*
                 3
               /   \
             1|2  4|5|6|7
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);

        tree.remove(0);
        tree.remove(8);
        assertEquals("[3]", tree.root.toString());
        assertEquals("[1, 2]", tree.root.children[0].toString());
        assertEquals("[4, 5, 6, 7]", tree.root.children[1].toString());
    }

    @Test
    @DisplayName("case2: remove directly")
    public void testRemove2() {
        /*
                 3
               /   \
             1|2  4|5|6|7
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);

        tree.remove(3);
        assertEquals("[1, 2, 4]", tree.root.toString());
        tree.remove(1);
        assertEquals("[2, 4]", tree.root.toString());
    }

    @Test
    @DisplayName("case4: replace with successor")
    public void testRemove3() {
        /*
                 3
               /   \
             1|2  4|5|6|7
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);

        tree.remove(3);
        assertEquals("[4]", tree.root.toString());
        assertEquals("[1, 2]", tree.root.children[0].toString());
        assertEquals("[5, 6, 7]", tree.root.children[1].toString());
    }

    @Test
    @DisplayName("case5: balance right rotate")
    public void testRemove4() { // 右旋
        /*
                  4
                /   \
             1|2|3  5|6
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(3);

        tree.remove(5);
        assertEquals("[3]", tree.root.toString());
        assertEquals("[1, 2]", tree.root.children[0].toString());
        assertEquals("[4, 6]", tree.root.children[1].toString());
    }

    @Test
    @DisplayName("case5: balance left rotate")
    public void testRemove5() {
        /*
                  3
                /   \
             1|2   4|5|6

                  4
                /   \
              1|3   5|6
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);

        tree.remove(2);
        assertEquals("[4]", tree.root.toString());
        assertEquals("[1, 3]", tree.root.children[0].toString());
        assertEquals("[5, 6]", tree.root.children[1].toString());
    }

    @Test
    @DisplayName("case5: balance merge a")
    public void testRemove6() { // 合并
        /*
                  3
                /   \
             1|2    4|5
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);

        tree.remove(4);
        assertEquals("[1, 2, 3, 5]", tree.root.toString());
    }

    @Test
    @DisplayName("case5: balance merge b")
    public void testRemove7() { // 合并
        /*
                  3
                /   \
             1|2    4|5
         */
        BTree tree = new BTree(3);
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);

        tree.remove(2);
        assertEquals("[1, 3, 4, 5]", tree.root.toString());
    }

    @Test
    @DisplayName("case6: from right to left")
    void testRemove8() {
        /*

                4|8                    4
               / | \                  / \
              2  6  10        =>     2  6|8
             /\  /\  /\             /\ / | \
            1 3 5 7 9 11           1 3 5 7 9|10


                4                       4
               / \                     / \
              2  6|8        =>        2   6
             /\ / | \                /\  / \
            1 3 5 7  9              1 3 5  7|8


                4                       4
               / \                     / \
              2   6         =>        2   _      =>     2|4
             /\   /\                 /\  /             / | \
            1  3 5  7               1 3 5|6           1 3 5|6

              2|4                       2
             / | \          =>         / \
            1 3  5                    1  3|4

        */
        BTree tree = new BTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.put(8);
        tree.put(9);
        tree.put(10);
        tree.put(11);
        tree.remove(11);
        assertEquals("[4]", tree.root.toString());
        assertEquals("[2]", tree.root.children[0].toString());
        assertEquals("[6, 8]", tree.root.children[1].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[5]", tree.root.children[1].children[0].toString());
        assertEquals("[7]", tree.root.children[1].children[1].toString());
        assertEquals("[9, 10]", tree.root.children[1].children[2].toString());
        tree.remove(10);
        assertEquals("[9]", tree.root.children[1].children[2].toString());
        tree.remove(9);
        assertEquals("[6]", tree.root.children[1].toString());
        assertEquals("[5]", tree.root.children[1].children[0].toString());
        assertEquals("[7, 8]", tree.root.children[1].children[1].toString());
        tree.remove(8);
        assertEquals("[7]", tree.root.children[1].children[1].toString());
        tree.remove(7);
        assertEquals("[2, 4]", tree.root.toString());
        assertEquals("[1]", tree.root.children[0].toString());
        assertEquals("[3]", tree.root.children[1].toString());
        assertEquals("[5, 6]", tree.root.children[2].toString());
        tree.remove(6);
        assertEquals("[5]", tree.root.children[2].toString());
        tree.remove(5);
        assertEquals("[2]", tree.root.toString());
        assertEquals("[1]", tree.root.children[0].toString());
        assertEquals("[3, 4]", tree.root.children[1].toString());
        tree.remove(4);
        assertEquals("[3]", tree.root.children[1].toString());
        tree.remove(3);
        assertEquals("[1, 2]", tree.root.toString());
        tree.remove(2);
        assertEquals("[1]", tree.root.toString());
        tree.remove(1);
        assertEquals("[]", tree.root.toString());
    }

    @Test
    @DisplayName("case6: from left to right")
    void testRemove9() {
        /*

                4|8                    4|8                  8
               / | \                  / | \                / \
              2  6  10        =>     _  6  10       =>   4|6  10
             /\  /\  /\             /   /\  /\          / | \  /\
            1 3 5 7 9 11           2|3 5 7 9 11       2|3 5 7 9 11


            remove(2,3) =>  8
                           / \
                          6   10
                         / \  /\
                        4|5 7 9 11

            remove(4,5) =>  8         =>        8|10
                           / \                 / | \
                          _   10             6|7 9 11
                         / \  /\
                        6|7   9 11

            remove(6,7)   =>   10
                               / \
                             8|9 11
        */
        BTree tree = new BTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.put(8);
        tree.put(9);
        tree.put(10);
        tree.put(11);
        tree.remove(1);
        assertEquals("[8]", tree.root.toString());
        assertEquals("[4, 6]", tree.root.children[0].toString());
        assertEquals("[10]", tree.root.children[1].toString());
        assertEquals("[2, 3]", tree.root.children[0].children[0].toString());
        assertEquals("[5]", tree.root.children[0].children[1].toString());
        assertEquals("[7]", tree.root.children[0].children[2].toString());
        assertEquals("[9]", tree.root.children[1].children[0].toString());
        assertEquals("[11]", tree.root.children[1].children[1].toString());
        tree.remove(2);
        tree.remove(3);
        assertEquals("[8]", tree.root.toString());
        assertEquals("[6]", tree.root.children[0].toString());
        assertEquals("[10]", tree.root.children[1].toString());
        assertEquals("[4, 5]", tree.root.children[0].children[0].toString());
        assertEquals("[7]", tree.root.children[0].children[1].toString());
        assertEquals("[9]", tree.root.children[1].children[0].toString());
        assertEquals("[11]", tree.root.children[1].children[1].toString());
        tree.remove(4);
        tree.remove(5);
        assertEquals("[8, 10]", tree.root.toString());
        assertEquals("[6, 7]", tree.root.children[0].toString());
        assertEquals("[9]", tree.root.children[1].toString());
        assertEquals("[11]", tree.root.children[2].toString());
        tree.remove(6);
        tree.remove(7);
        assertEquals("[10]", tree.root.toString());
        assertEquals("[8, 9]", tree.root.children[0].toString());
        assertEquals("[11]", tree.root.children[1].toString());
        tree.remove(8);
        tree.remove(9);
        assertEquals("[10, 11]", tree.root.toString());
        assertTrue(tree.root.leaf);
        tree.remove(10);
        tree.remove(11);
        assertEquals("[]", tree.root.toString());
    }

    @Test
    @DisplayName("case6: delete middle")
    void testRemove11() {
        /*

                4|8                5|8               5|8                8
               / | \              / | \             / | \              / \
              2  6  10      =>   2  6  10      =>  2  _  10       => 2|5  10
             /\  /\  /\         /\  /\  /\        /\  |  /\         / | \  /\
            1 3 5 7 9 11       1 3 _ 7 9 11      1 3 6|7 9 11      1 3 6|7 9 11


                 8                    9                 9                5
                / \                /    \            /    \           /    \
              2|5  10     =>     2|5    10     =>  2|5     _    =>   2      9
             / | \  /\          / | \   /\        / | \    |        /\    /  \
            1 3 6|7 9 11       1 3 6|7 _ 11      1 3 6|7 10|11     1 3  6|7 10|11


                  5
               /    \
              2      9     =>
             /\    /  \
            1 3  6|7 10|11

                  6                    7                7
               /    \               /    \           /    \
              2      9     =>      2      9     =>  2     10
             /\    /  \           /\    /  \       /\    /  \
            1 3   7  10|11       1 3   _  10|11   1 3   9   11

                 7                   9                9
               /  \                /  \              / \
              2   10       =>     2   10     =>     2   _      =>   2|9
             /\   / \            /\   / \          /\   |          / | \
            1 3  9  11          1 3  _  11        1 3 10|11       1  3 10|11

               2|9                 3|9                3|10
              / | \         =>    / | \       =>     / | \
             1  3 10|11          1  _ 10|11         1  9  11

               3|10                9|10               10
              / | \         =>    / | \       =>     / \
             1  9  11            1  _  11          1|9  11

               10                   11               9
              / \           =>     / \        =>    / \
            1|9  11              1|9  _            1  11

               9                    11
              / \         =>       / \        =>    1|11
             1  11                1   _
        */
        BTree tree = new BTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.put(8);
        tree.put(9);
        tree.put(10);
        tree.put(11);
        tree.remove(4);
        assertEquals("[8]", tree.root.toString());
        assertEquals("[2, 5]", tree.root.children[0].toString());
        assertEquals("[10]", tree.root.children[1].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[6, 7]", tree.root.children[0].children[2].toString());
        assertEquals("[9]", tree.root.children[1].children[0].toString());
        assertEquals("[11]", tree.root.children[1].children[1].toString());
        tree.remove(8);
        assertEquals("[5]", tree.root.toString());
        assertEquals("[2]", tree.root.children[0].toString());
        assertEquals("[9]", tree.root.children[1].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[6, 7]", tree.root.children[1].children[0].toString());
        assertEquals("[10, 11]", tree.root.children[1].children[1].toString());
        tree.remove(5);
        assertEquals("[6]", tree.root.toString());
        assertEquals("[2]", tree.root.children[0].toString());
        assertEquals("[9]", tree.root.children[1].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[7]", tree.root.children[1].children[0].toString());
        assertEquals("[10, 11]", tree.root.children[1].children[1].toString());
        tree.remove(6);
        assertEquals("[7]", tree.root.toString());
        assertEquals("[2]", tree.root.children[0].toString());
        assertEquals("[10]", tree.root.children[1].toString());
        assertEquals("[1]", tree.root.children[0].children[0].toString());
        assertEquals("[3]", tree.root.children[0].children[1].toString());
        assertEquals("[9]", tree.root.children[1].children[0].toString());
        assertEquals("[11]", tree.root.children[1].children[1].toString());
        tree.remove(7);
        assertEquals("[2, 9]", tree.root.toString());
        assertEquals("[1]", tree.root.children[0].toString());
        assertEquals("[3]", tree.root.children[1].toString());
        assertEquals("[10, 11]", tree.root.children[2].toString());
        tree.remove(2);
        assertEquals("[3, 10]", tree.root.toString());
        assertEquals("[1]", tree.root.children[0].toString());
        assertEquals("[9]", tree.root.children[1].toString());
        assertEquals("[11]", tree.root.children[2].toString());
        tree.remove(3);
        assertEquals("[10]", tree.root.toString());
        assertEquals("[1, 9]", tree.root.children[0].toString());
        assertEquals("[11]", tree.root.children[1].toString());
        tree.remove(10);
        assertEquals("[9]", tree.root.toString());
        assertEquals("[1]", tree.root.children[0].toString());
        assertEquals("[11]", tree.root.children[1].toString());
        tree.remove(9);
        assertEquals("[1, 11]", tree.root.toString());
    }

}