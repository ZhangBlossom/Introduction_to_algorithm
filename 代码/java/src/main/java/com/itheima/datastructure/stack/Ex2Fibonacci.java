package com.itheima.datastructure.stack;

public class Ex2Fibonacci {
    static class Frame<E> {
        int n;
        int x;
        E result;
        int returnBranch;
        int branch;

        public Frame(int n, int branch, int returnBranch) {
            this.n = n;
            this.branch = branch;
            this.returnBranch = returnBranch;
        }

        @Override
        public String toString() {
            return "State{" +
                    "n=" + n +
                    ", r=" + result +
                    '}';
        }
    }

    public static Integer f(int n) {
        ArrayStack<Frame<Integer>> stack = new ArrayStack<>(n + 1);
        stack.push(new Frame<>(n, 0, 4));
        while (!stack.isEmpty()) {
            Frame<Integer> curr = stack.peek();
            switch (curr.branch) {
                case 0 -> {
                    if (curr.n == 0) {
                        curr.result = 0;
                        curr.branch = curr.returnBranch;
                    } else if (curr.n == 1) {
                        curr.result = 1;
                        curr.branch = curr.returnBranch;
                    } else {
                        curr.branch = 1;
                    }
                }
                case 1 -> {
                    stack.push(new Frame<>(curr.n - 1, 0, 2));
                }
                case 2 -> {
                    Frame<Integer> x = stack.pop();
                    Frame<Integer> prev = stack.peek();
                    prev.x = x.result;
                    stack.push(new Frame<>(prev.n - 2, 0, 3));
                }
                case 3 -> {
                    Frame<Integer> y = stack.pop();
                    Frame<Integer> prev = stack.peek();
                    prev.result = prev.x + y.result;
                    prev.branch = prev.returnBranch;
                }
                case 4 -> {
                    return curr.result;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(f(8));
    }
}
