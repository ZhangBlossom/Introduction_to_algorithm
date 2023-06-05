package proxytest.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/12 15:24
 * Description:
 * Version: 1.0.0
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?>clazz){
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        //创建代理类
        return enhancer.create();

    }
}
