package com.base.learn.queue;



import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 张锦标
 * @date: 2023/6/10 10:33
 * QueueMakeStack类
 */
public class TwoQueueMakeStack {
    //每次最新元素都插入到pushQueue中
    private Queue<Integer> pushQueue;
    //出栈的时候使用这个popQueue，用于存放老旧元素
    private Queue<Integer> popQueue;


    public TwoQueueMakeStack() {
        pushQueue = new LinkedList<Integer>();
        popQueue = new LinkedList<Integer>();
    }

    public void push(int x) {
        //pushQueue.offer(x);
        //while(!popQueue.isEmpty()){
        //    pushQueue.offer(popQueue.poll());
        //}
        //Queue<Integer> temp = popQueue;
        //popQueue = pushQueue;
        //pushQueue = temp;
        //一个队列也可以实现栈
        int size = popQueue.size();
        popQueue.offer(x);
        for(int i=0;i<size;i++){
            popQueue.offer(popQueue.poll());
        }
    }

    public int pop() {
        return popQueue.poll();
    }

    public int top() {
        return popQueue.peek();
    }

    public boolean empty() {
        return popQueue.isEmpty();
    }
}
