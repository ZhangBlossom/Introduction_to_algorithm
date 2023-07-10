package nowcoder.hw;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 张锦标
 * @date: 2023/7/6 19:58
 * HexadecimalToDecimal类
 * 十六进制转换为十进制
 */
public class HexadecimalToDecimal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hex = in.nextLine();
        int count = 0;
        for(int i = hex.length()-1,j=0;i>=2;i--,j++){
            char c = hex.charAt(i);
            if (Character.isDigit(c)){
                count+=(Math.pow(16,j)*((int)(c-'0')));
            }else{
                count +=((int)(Math.pow(16,j) * (c-'A'+10)));
            }
        }
        System.out.println(count);
    }
}
