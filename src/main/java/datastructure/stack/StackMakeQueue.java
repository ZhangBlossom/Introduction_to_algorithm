package datastructure.stack;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/5/27 14:43
 * StackMakeQueue类
 * 使用两个栈形成一个队列
 * 支持队列的add poll peek
 */
public class StackMakeQueue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    public void add(int num){
        stackPush.push(num);
        inToOut();
    }
    private void inToOut(){
        //只有空的时候才能把in的数据放入到out,不然顺序就乱了
        if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("栈中并没有数据");
        }
        //如果说in栈中有数据 但是out栈中没有 那么把数据移动到out栈中
        inToOut();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("栈中并没有数据");
        }
        //如果说in栈中有数据 但是out栈中没有 那么把数据移动到out栈中
        inToOut();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        StackMakeQueue stackMakeQueue = new StackMakeQueue();
        stackMakeQueue.add(1);
        stackMakeQueue.add(2);
        stackMakeQueue.add(3);
        System.out.println(stackMakeQueue.poll());
        System.out.println(stackMakeQueue.poll());
        System.out.println(stackMakeQueue.poll());
    }
}
