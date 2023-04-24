package test.java.proxytest.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/12 15:09
 * Description:
 * Version: 1.0.0
 */
public class JdkProxy implements InvocationHandler {
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理前缀");
        Object o = method.invoke(target, args);
        System.out.println("jdk动态代理后缀");
        return "返回值为：" + o;
    }

    public static void main(String[] args) {
        UserService userService = (UserService) JdkProxyFactory.getProxy(new UserServiceImpl());
        String s = userService.sendMsg("你好呀 动态代理");
        System.out.println(s);
    }
}
