package nowcoder.xiecheng;




import java.util.Scanner;

/**
 * @author: 张锦标
 * @date: 2023/7/8 21:21
 * Fall51类
 */
public class StrConstruct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            if (n<k*3 || n<0 || k<0){
                System.out.println(-1);
            }
            char[] arr = new char[n];
            for(int i=0;i<k;i++){
                arr[i*3] = 'y';
                arr[i*3+1] = 'o';
                arr[i*3+2] = 'u';
            }
            for(int i=3*k;i<n;i++){
                arr[i] = 'y';
            }
            System.out.println(new String(arr));
        }
    }
}
