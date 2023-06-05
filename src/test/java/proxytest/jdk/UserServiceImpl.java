package proxytest.jdk;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/12 15:10
 * Description:
 * Version: 1.0.0
 */
public class UserServiceImpl implements UserService {
    public String sendMsg(String msg){
        System.out.println("发送短信："+msg);
        return msg;
    }
}
