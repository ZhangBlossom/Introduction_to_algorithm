package com.itheima.lambda;

public class TestMethodCall {
    static class Father {
        void foo() {
            System.out.println("father");
        }
    }

    static class Child extends Father {
        void foo() {
            System.out.println("child");
        }

        void bar(){
            super.foo();
        }
    }

    public static void main(String[] args) {
        Child f = new Child();
        f.bar();
    }
}
