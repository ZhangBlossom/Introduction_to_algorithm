package com.itheima.lambda;

class Superclass {

    final void interestingMethod() {
        System.out.println("Superclass's interesting method.");
    }

    void exampleMethod() {
        interestingMethod();
    }
}

class Subclass extends Superclass {

//    void interestingMethod() {
//        System.out.println("Subclass's interesting method.");
//    }

    public static void main(String args[]) {
        Subclass me = new Subclass();
        me.exampleMethod();
    }
}