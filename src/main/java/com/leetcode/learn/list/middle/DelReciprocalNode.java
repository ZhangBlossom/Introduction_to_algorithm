package com.leetcode.learn.list.middle;

import com.leetcode.learn.list.ListNode;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/6/16 20:08
 * DelReciprocalNode类
 */
public class DelReciprocalNode {
    public static ListNode removeReciprocalNode(ListNode root,int n){
        ListNode temp = new ListNode(0,root);
        Stack<ListNode> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        for(int i=0;i<n;i++){
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return root;
    }
}
