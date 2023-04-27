package com.itheima.other;

public class GetNumber {
    static class Lock {
        int number = 1;
    }

    static abstract class Task implements Runnable {

        private final Lock lock;

        public Task(Lock lock) {
            this.lock = lock;
        }

        abstract boolean check(int number); // 满足什么条件继续

        abstract void doTask(int number); // 执行具体操作

        @Override
        public void run() {
            while (lock.number < 100) {
                synchronized (lock) {
                    while (!check(lock.number)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    doTask(lock.number);
                    // 改变条件,让别人运行
                    lock.number++;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new Lock();

        Thread t1 = new Thread(new Task(lock) {
            @Override
            boolean check(int number) {
                return number % 2 == 1;
            }

            @Override
            void doTask(int number) {
                colorPrintln(number, 31);
            }
        });

        Thread t2 = new Thread(new Task(lock) {
            @Override
            boolean check(int number) {
                return number % 2 == 0;
            }

            @Override
            void doTask(int number) {
                colorPrintln(number, 34);
            }
        });

        t1.start();
        t2.start();
    }

    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(int origin, int color) {
        System.out.printf("\033[%dm%d\033[0m%n", color, origin);
    }
}