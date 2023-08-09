package offer.stack;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/5/27 14:30
 * getMinStack类
 * 实现一个特殊的栈,这个栈要求能直接返回栈中最小的元素
 */
public class GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    public void push(int newNum){
        this.stackData.push(newNum);
        if (stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum<=this.getMin()){
            stackMin.push(newNum);
        }
    }
    public int pop(){
        if (this.stackData.isEmpty()){
            throw  new RuntimeException("stackData is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }
    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("stackMin is empty");
        }
        return stackMin.peek();
    }
}
