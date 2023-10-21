package async;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 张锦标
 * @date: 2023/10/21 18:58
 * CompletableFutureTest类
 */
public class CompletableFutureTest {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(3, 5, 30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10), new ThreadFactory() {
        private final AtomicInteger THREAD_NUM = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
//      设置为守护线程，main线程结束就跟着一起结束，否则main函数结束jvm还在
            t.setDaemon(true);
            t.setName("completable-future-test-Thread-" + THREAD_NUM.incrementAndGet());
            return t;
        }
    }, new ThreadPoolExecutor.AbortPolicy());


    //异步串行
    public static void serial() {
        CompletableFuture.supplyAsync(() -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task1";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            System.out.println(taskName + "执行结束");
            return taskName;
        }, THREAD_POOL_EXECUTOR).thenApply((task1Result) -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task2";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            System.out.println("拿到上一个任务的返回值：" + task1Result);
            System.out.println(taskName + "执行结束");
            return taskName;
        }).thenAccept((task2Result) -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task3";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            System.out.println("拿到上一个任务的返回值：" + task2Result);
            System.out.println(taskName + "执行结束");
        });
    }

    //并行
    public static void parallel() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task1";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            System.out.println(taskName + "执行结束");
            return taskName;
        }, THREAD_POOL_EXECUTOR);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task2";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            System.out.println(taskName + "执行结束");
        }, THREAD_POOL_EXECUTOR);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            Thread currentThread = Thread.currentThread();
            String ThreadName = currentThread.getName();
            String taskName = "task3";
            System.out.println(ThreadName + "开始执行任务：" + taskName);
            System.out.println("正在执行任务" + taskName);
            System.out.println(taskName + "执行结束");
            return taskName;
        }, THREAD_POOL_EXECUTOR);

    }

    //任务3依赖于任务12
    public static void combine() throws ExecutionException, InterruptedException {
        CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task1";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    return taskName;
                }, THREAD_POOL_EXECUTOR).thenCombine(CompletableFuture
                                // 任务2
                                .supplyAsync(() -> {
                                    Thread currentThread = Thread.currentThread();
                                    String ThreadName = currentThread.getName();
                                    String taskName = "task2";
                                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                                    System.out.println("正在执行任务" + taskName);
                                    System.out.println(taskName + "执行结束");
                                    return taskName;
                                }, THREAD_POOL_EXECUTOR),
                        // 任务3 依赖于任务1 2
                        (task1Result, task2Result) -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task3";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("task1结果：" + task1Result + "\ttask2结果：" + task2Result);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                            return taskName;
                        });

    }

    //任务3依赖于任务12 并且任务3也用单独的线程执行
    public static void combineAsync() {
        CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task1";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    return taskName;
                }, THREAD_POOL_EXECUTOR).thenCombineAsync(CompletableFuture
                                // 任务2
                                .supplyAsync(() -> {
                                    Thread currentThread = Thread.currentThread();
                                    String ThreadName = currentThread.getName();
                                    String taskName = "task2";
                                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                                    System.out.println("正在执行任务" + taskName);
                                    System.out.println(taskName + "执行结束");
                                    return 2;
                                }, THREAD_POOL_EXECUTOR),
                        // 任务3
                        (task1Result, task2Result) -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task3";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("task1结果：" + task1Result + "\ttask2结果：" + task2Result);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                            return 2L;
                        }, THREAD_POOL_EXECUTOR);

    }

    // 如果任务3中不需要返回结果，可以使用thenAcceptBoth()或thenAcceptBothAsync()，使用方式与thenCombineAsync()类似；
    public static void combineAsyncNoReturn() {
        CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task1";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    return taskName;
                }, THREAD_POOL_EXECUTOR).thenAcceptBothAsync(CompletableFuture
                                // 任务2
                                .supplyAsync(() -> {
                                    Thread currentThread = Thread.currentThread();
                                    String ThreadName = currentThread.getName();
                                    String taskName = "task2";
                                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                                    System.out.println("正在执行任务" + taskName);
                                    System.out.println(taskName + "执行结束");
                                    return 2;
                                }, THREAD_POOL_EXECUTOR),
                        // 任务3
                        (task1Result, task2Result) -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task3";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("task1结果：" + task1Result + "\ttask2结果：" + task2Result);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                        }, THREAD_POOL_EXECUTOR);

    }

    //多任务合并 大于等于3个任务
    public static void tasksCombine() {
        CompletableFuture future1 = CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task1";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    return taskName;
                }, THREAD_POOL_EXECUTOR);
        CompletableFuture future2 = CompletableFuture
                // 任务2
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task2";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    return taskName;
                }, THREAD_POOL_EXECUTOR);
        CompletableFuture future3 = CompletableFuture
                // 任务3
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task3";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    int i = 1 / 0;
                    return taskName;
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture[] futures = new CompletableFuture[]{future1, future2, future3};
        // 任务4
        // whenCompleteAsync 方法的回调中的 v 参数实际上是一个 Void 类型，
        // 因为 whenCompleteAsync 方法不返回结果，而只是用于在所有任务完成时触发。
        // 所以，v 在这里不包含任何有用的计算结果。
        // 这里的e指的是前面的任务如果出现异常，尼玛在这里会被e捕获
        CompletableFuture           //anyOf则是只要任一任务完成即可
                .allOf(futures) //allOf需要所有任务完成才会执行后面的任务
                .whenCompleteAsync((v, e) -> {
                    List<Object> values = new ArrayList<>();
                    for (CompletableFuture future : futures) {
                        try {
                            values.add(future.get());
                        } catch (Exception ex) {
                            System.out.println(e.getCause());
                        }
                    }
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task4";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("前面任务的处理结果：" + values);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    System.out.println(v);
                }, THREAD_POOL_EXECUTOR);

    }

    //如果前面的任务出现异常时的捕获操作
    //如果前面的任务正常执行 则继续执行正常流程
    public static void tasksCombineException() {
        CompletableFuture<String> future1 = CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    // 任务1的代码
                    return "task1";
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture<String> future2 = CompletableFuture
                // 任务2
                .supplyAsync(() -> {
                    // 任务2的代码
                    return "task2";
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture<String> future3 = CompletableFuture
                // 任务3
                .supplyAsync(() -> {
                    // 任务3的代码
                    int i = 1 / 0;  // 引发异常
                    return "task3";
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture[] futures = new CompletableFuture[]{future1, future2, future3};

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures);

        combinedFuture.exceptionally(ex -> {
            System.out.println("前面任务中出现异常：" + ex.getCause());
            return null;  // 返回默认值
        });

        CompletableFuture<Void> task4Future = combinedFuture.thenAccept(v -> {
            if (!future1.isCompletedExceptionally() && !future2.isCompletedExceptionally() && !future3.isCompletedExceptionally()) {
                // 前面的任务没有出现异常，执行任务4
                Thread currentThread = Thread.currentThread();
                String ThreadName = currentThread.getName();
                String taskName = "task4";
                System.out.println(ThreadName + "开始执行任务：" + taskName);
                System.out.println("前面任务的处理结果：" + Arrays.asList(future1.join(), future2.join(), future3.join()));
                System.out.println("正在执行任务" + taskName);
                System.out.println(taskName + "执行结束");
            }
        });

        task4Future.join();  // 等待任务4完成
    }

    //如果有一个任务抛出异常的解决方法
    public static void tasksWithException() {
        CompletableFuture future1 = CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task1";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    return taskName;
                }, THREAD_POOL_EXECUTOR);
        CompletableFuture future2 = CompletableFuture
                // 任务2
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task2";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");

                    throw new RuntimeException("任务2异常！");
                }, THREAD_POOL_EXECUTOR);
        CompletableFuture future3 = CompletableFuture
                // 任务3
                .supplyAsync(() -> {
                    Thread currentThread = Thread.currentThread();
                    String ThreadName = currentThread.getName();
                    String taskName = "task3";
                    System.out.println(ThreadName + "开始执行任务：" + taskName);
                    System.out.println("正在执行任务" + taskName);
                    System.out.println(taskName + "执行结束");
                    throw new RuntimeException("任务3异常！");
                }, THREAD_POOL_EXECUTOR);
        CompletableFuture[] futures = new CompletableFuture[]{future1, future2, future3};
        CompletableFuture allCompletableFuture = CompletableFuture.allOf(futures);
        // 创建一个任务来监听异常
        CompletableFuture<?> anyException = new CompletableFuture<>();
        for (CompletableFuture<?> completableFuture : futures) {
            completableFuture.exceptionally((t) -> {
                // 任何一个任务异常都会让anyException任务完成
                anyException.completeExceptionally(t);
                return null;
            });
        }
        // 要么allCompletableFuture全部成功，要么一个出现异常就结束任务
        CompletableFuture.anyOf(allCompletableFuture, anyException).whenComplete((value, exception) -> {
            if (Objects.nonNull(exception)) {
                System.out.println("产生异常，提前结束！");
                exception.printStackTrace();
                return;
            }
            System.out.println("所有任务正常完成！");
        });

    }

    //得到多个任务的返回值
    public static void tasksReturn() {
        CompletableFuture<String> future1 = CompletableFuture
                // 任务1
                .supplyAsync(() -> {
                    // 任务1的代码
                    return "task1";
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture<String> future2 = CompletableFuture
                // 任务2
                .supplyAsync(() -> {
                    // 任务2的代码
                    return "task2";
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture<String> future3 = CompletableFuture
                // 任务3
                .supplyAsync(() -> {
                    // 任务3的代码
                    return "task3";
                }, THREAD_POOL_EXECUTOR);

        CompletableFuture<List<String>> combinedFuture =
                CompletableFuture.allOf(future1, future2, future3).thenApply(v -> Arrays.asList(future1.join(),
                        future2.join(), future3.join()));

        // 等待任务4完成并获取其结果
        List<String> task4Result = combinedFuture.join();
        System.out.println("任务4的处理结果：" + task4Result);

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        tasksCombine();
    }
}
