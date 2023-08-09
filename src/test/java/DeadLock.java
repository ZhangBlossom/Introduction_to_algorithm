import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * @author: 张锦标
 * @date: 2023/7/31 14:21
 * DeadLock类
 */
public class DeadLock {
    public static void main(String[] args) {
        //拦截器 过滤器 MVC的处理流程顺序
        //G1垃圾回收器
        //死锁
        //EasyConfig
        Object lockA = new Object();
        Object lockB = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (lockA){
                    System.out.println("现在的线程是"+name);
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){
                        System.out.println("-------");
                    }
                    synchronized (lockB){
                        System.out.println("当前线程是"+name);
                        System.out.println(name+"hello this is a thread");
                    }
                }
            };
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (lockB){
                    System.out.println("现在的线程是"+name);
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){
                        System.out.println("-------");
                    }
                    synchronized (lockA){
                        System.out.println("当前线程是"+name);
                        System.out.println(name+"hello this is a thread");
                    }
                }
            };
        }).start();
    }
}
