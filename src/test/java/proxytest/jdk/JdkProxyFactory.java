package test.java.proxytest.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/12 15:12
 * Description:
 * Version: 1.0.0
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkProxy(target));
    }
}
