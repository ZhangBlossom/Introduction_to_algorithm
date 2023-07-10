package nowcoder.hw;

import java.util.Scanner;

/**
 * @author: 张锦标
 * @date: 2023/7/6 19:52
 * SodaBottle类
 */
public class SodaBottle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int kp = in.nextInt();
            if(kp==0){
                break;
            }
            if(kp==1){
                System.out.println(0);;
            }
            if(kp==2){
                System.out.println(1);
            }
            System.out.println(func(kp));
        }
    }
    public static int func(int kp){
        if(kp<2){
            return 0;
        }
        if(kp==2){
            return 1;
        }
        int qs = kp/3;
        kp = kp%3;
        kp+=qs;
        return qs+func(kp);
    }

}
