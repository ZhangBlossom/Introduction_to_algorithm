package test.java.proxytest.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/12 15:21
 * Description:
 * Version: 1.0.0
 */
public class DebugMethodInterceptor implements MethodInterceptor {
    /**
     * obj : 被代理的对象（需要增强的对象）
     * method : 被拦截的方法（需要增强的方法）
     * args : 方法入参
     * proxy : 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理前缀");
        //Object invoke = method.invoke(o, objects);
        System.out.println("被拦截的方法为:"+method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib动态代理后缀");
        return o1;
    }

    public static void main(String[] args) {
        AliSmsService service = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        System.out.println(service.send("cglib发送消息"));
    }
}
