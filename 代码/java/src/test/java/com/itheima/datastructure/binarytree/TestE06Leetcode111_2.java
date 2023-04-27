package com.itheima.datastructure.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestE06Leetcode111_2 {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(3));
        assertEquals(2, new E06Leetcode111_2().minDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        assertEquals(2, new E06Leetcode111_2().minDepth(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, new E06Leetcode111_2().minDepth(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, null);
        assertEquals(2, new E06Leetcode111_2().minDepth(root));
    }
}
