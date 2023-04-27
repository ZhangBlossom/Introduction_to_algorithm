package com.itheima.datastructure.stack;

import com.itheima.datastructure.queue.ArrayQueue3;

/**
 * 单队列模拟栈
 * <ol>
 *     <li>调用 push、pop 等方法的次数最多 100</li>
 *     <li>每次调用 pop 和 top 都能保证栈不为空</li>
 * </ol>
 */
public class E05Leetcode225 {
    /*

        栈顶      栈底
        d    c    b    a
        队列头    队列尾

        queue.offer(a)
        queue.offer(b)
        queue.offer(c)

        push 添加
            - 将新加入元素，前面的所有元素从队列头移动到队列尾
        pop 移除
            - 直接移除队列头元素

     */
    ArrayQueue3<Integer> queue = new ArrayQueue3<>(100);
    private int size = 0;

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
