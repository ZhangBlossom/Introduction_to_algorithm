package test.java.proxytest.jdk;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/12 15:31
 * Description:
 * Version: 1.0.0
 */
public class StaticProxy implements ProxyService{
    private ProxyService proxyService;
    public StaticProxy(ProxyService proxyService){
        this.proxyService=proxyService;
    }
    @Override
    public String sendMsg(String msg) {
        System.out.println("静态代理前缀");
        String s = proxyService.sendMsg(msg);
        System.out.println("静态代理后缀");
        return s;
    }

    public static void main(String[] args) {
        ProxyServiceImpl proxyService1 = new ProxyServiceImpl();
        StaticProxy staticProxy = new StaticProxy(proxyService1);
        System.out.println(staticProxy.sendMsg("发送一个消息"));
    }
}
class ProxyServiceImpl implements ProxyService{
    @Override
    public String sendMsg(String msg) {
        System.out.println("静态代理方法调用:"+msg);
        return msg;
    }
}
interface ProxyService{
    public String sendMsg(String msg);
}
