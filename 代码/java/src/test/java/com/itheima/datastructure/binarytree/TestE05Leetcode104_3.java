package com.itheima.datastructure.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestE05Leetcode104_3 {

    private final E05Leetcode104_3 e05 = new E05Leetcode104_3();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(3));
        assertEquals(2, e05.maxDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        assertEquals(3, e05.maxDepth(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, e05.maxDepth(root));
    }
}
