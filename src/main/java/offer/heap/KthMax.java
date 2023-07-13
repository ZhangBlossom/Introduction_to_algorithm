package offer.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author: 张锦标
 * @date: 2023/7/12 17:14
 * KthMax类
 */
public class KthMax {
    //使用优先队列暴力解决这道题 优先队列底层还是堆
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor tpe;
        tpe = new ThreadPoolExecutor(
                1, 1, 1, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>()
        );
        List<Future<Integer>> list= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ComparableFutureTask c = new ComparableFutureTask(new B(i),i+1);
            //tpe.execute(c);
            tpe.submit(c);
            Thread.sleep(1000);
            list.add(c);
        }
        list.forEach(x->{
            System.out.println(x);
        });
        tpe.shutdown();
    }
}

class ComparableFutureTask extends FutureTask<Integer> implements Comparable<ComparableFutureTask> {
    private Integer priority;

    public Integer getPriority() {
        return priority;
    }
    public ComparableFutureTask(Callable<Integer> callable, Integer priority) {
        super(callable);
        this.priority = priority;
    }

    @Override
    public int compareTo(ComparableFutureTask task) {
        if (this.getPriority() < task.getPriority()){
            return 1;
        }else if (this.getPriority() > task.getPriority()){
            return -1;
        }
        return 0;
    }

}

class B implements Callable<Integer>{
    private Integer id;

    public B(Integer priority) {
        this.id = priority;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("Thread " + Thread.currentThread().getName() + " priority " + id);

        try{

            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " 开始执行任务 ...");

        return id;
    }

}
class A implements Comparable<A>, Runnable {
    Integer priority;

    public A(Integer p) {
        this.priority = p;
    }

    @Override
    public int compareTo(A o) {
        return this.priority - o.priority;
    }

    @Override
    public void run() {
        System.out.println("hello world");
    }
}
