package com.itheima.datastructure.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestE04Leetcode101 {

    @Test
    public void test1() {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(3), 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4), 2, new TreeNode(3))
        );
        assertTrue(new E04Leetcode101().isSymmetric(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(
                new TreeNode(null, 2, new TreeNode(3)),
                1,
                new TreeNode(null, 2, new TreeNode(3))
        );
        assertFalse(new E04Leetcode101().isSymmetric(root));
    }
}
