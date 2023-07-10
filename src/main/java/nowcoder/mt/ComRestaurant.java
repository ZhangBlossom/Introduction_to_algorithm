package nowcoder.mt;

import java.util.Scanner;

/**
 * @author: 张锦标
 * @date: 2023/7/10 9:10
 * ComRestaurant类
 * 公司食堂
 */
public class ComRestaurant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] arrLen = new int[T]; //桌子个数
        String[] arrTable = new String[T];//桌子构成
        int[] arrPerson = new int[T];//总人数
        String[] arrMan = new String[T]; //当前男女构成
        // 注意 hasNext 和 hasNextLine 的区别
        int i = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            arrLen[i] = in.nextInt();
            arrTable[i] = in.nextLine();
            arrPerson[i] = in.nextInt();
            arrMan[i++] = in.nextLine();
        }
        for(int j = 0;j<T;j++){

        }
    }

}
