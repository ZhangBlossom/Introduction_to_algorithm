package test.java.multhread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/14 11:38
 * Description:
 * Version: 1.0.0
 */
public class SynchronizedTest {
    public synchronized static String function1() {
        System.out.println("hello this is static synchroinzed function");
        return "hello this is static synchroinzed function";
    }

    public synchronized String function2() {
        System.out.println("hello this is  synchroinzed function");
        return "hello this is  synchroinzed function";
    }

    public String function3() {
        //这里的this只得是当前的实例对象
        synchronized (this) {
            System.out.println("hello this is  synchroinzed function");
            return "hello this is  synchroinzed function";
        }
    }
    public String function4() {
        //这里的this只得是当前的实例对象
        synchronized (this.getClass()) {
            System.out.println("hello this is  synchroinzed function");
            return "hello this is  synchroinzed function";
        }
    }

    public static void main(String[] args) {
        SynchronizedTest.function1();
        SynchronizedTest st = new SynchronizedTest();
        st.function2();
        st.function3();
        st.function4();
    }
}
