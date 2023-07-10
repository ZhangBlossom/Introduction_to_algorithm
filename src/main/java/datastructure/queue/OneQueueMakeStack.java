package datastructure.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 张锦标
 * @date: 2023/6/10 10:44
 * OneQueueMakeStack类
 */
public class OneQueueMakeStack {
    private Queue<Integer> queue ;
    public OneQueueMakeStack(){
        queue = new LinkedList<Integer>();
    }
    public void push(int x){
        int size = queue.size();
        queue.offer(x);
        for(int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
    }
    public int pop(){
        return queue.poll();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
