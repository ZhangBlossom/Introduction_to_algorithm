package com.leetcode.learn.tree.easy;

import com.leetcode.learn.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/14 22:27
 * LeftSum类
 */
public class LeftSum {
    private static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        calculate(root,false);
        return sum;
    }

    private static  void calculate(TreeNode node, boolean isLeft) {
        if (node==null){
            return;
        }
        if (node.left==null && node.right==null && isLeft){
            sum+=node.val;
        }
        calculate(node.left,true);
        calculate(node.right,false);
    }
}
