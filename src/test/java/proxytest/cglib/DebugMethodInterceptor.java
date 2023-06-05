package proxytest.cglib;

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
    public Object intercept(Object o, Method method,
                            Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        System.out.println("被代理的对象："+o.getClass());
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;
    }

    public static void main(String[] args) {
        AliSmsService service =
                (AliSmsService) CglibProxyFactory
                                .getProxy(AliSmsService.class);
        System.out.println(service.send("cglib发送消息"));
    }
}
