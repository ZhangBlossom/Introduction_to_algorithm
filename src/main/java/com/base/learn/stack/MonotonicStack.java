package com.base.learn.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/5/28 11:00
 * MonotonicStack类
 * 单调栈题目
 */
public class MonotonicStack {
    /**
     * 暴力解决
     * @param arr
     * @return
     */
    public static int[][] violentSolution(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftMin = -1;
            int rightMin = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftMin = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightMin = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftMin;
            res[i][1] = rightMin;
        }
        return res;
    }

    public static int[][] monotonicStackNorepeat(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            //如果当前栈不为空并且当前值比栈顶对应的元素小
            //那么就开始出栈 因为这说明栈内元素遇到了比自己小的数据了
            //并且一直出栈直到栈顶元素比当前元素小
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                //出栈得到栈顶元素对应的索引
                int popIndex = stack.pop();
                //判断栈顶元素的左边是否还有元素 如果有 那么比栈顶元素的左边最小就是这个元素
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                //比栈顶元素右边小的元素的位置为i
                res[popIndex][1] = i;
            }
            //放入当前元素 开启新一轮循环
            stack.push(i);
        }
        //清算阶段 对于还在栈中的元素
        while (!stack.isEmpty()) {
            //取出当前元素对应的索引位置
            int popIndex = stack.pop();
            //判断是否他们的左边还有值？左边的值都是比他们小的值
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            //清算阶段还在栈中说明他们的右边都是比他们大的或者就是已经没有后面的元素了
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static int[][] monotonicStackRepeat(int[] arr) {
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            //如果当前栈不为空并且当前值比栈顶对应的元素小
            //那么就开始出栈 因为这说明栈内元素遇到了比自己小的数据了
            //并且一直出栈直到栈顶元素比当前元素小
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                //出栈得到栈顶元素对应的索引
                List<Integer> popList = stack.pop();
                //判断栈顶元素的左边是否还有元素 如果有 那么比栈顶元素的左边最小就是这个元素
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                        stack.peek().size()-1
                );
                for (Integer popi : popList) {
                    res[popi][0]=leftLessIndex;
                    res[popi][1] = i;
                }
            }
            //判断当前栈是否为空 不为空则取出栈顶列表并且放入当前元素
            if (!stack.isEmpty() && arr[stack.peek().get(0)]==arr[i]){
                stack.peek().add(Integer.valueOf(i));
            }else{
                //栈为空 或者当前元素与栈顶元素不一样 那么直接创建一个新的list
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        //清算阶段 对于还在栈中的元素
        while (!stack.isEmpty()) {
            //出栈得到栈顶元素对应的索引
            List<Integer> popList = stack.pop();
            //判断栈顶元素的左边是否还有元素 如果有 那么比栈顶元素的左边最小就是这个元素
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                    stack.peek().size()-1
            );
            for (Integer popi : popList) {
                res[popi][0]=leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(monotonicStackNorepeat(new int[]{3,4,1,5,6,2,7})));
    }
}
