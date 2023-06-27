package leetcode.math;

/**
 * @author: 张锦标
 * @date: 2023/6/14 21:55
 * PowerOfThree类
 */
public class PowerOfThree {
    public static boolean isPowerOfThree(int n){
        if(n==1){
            return true;
        }else if(n==0){
            return false;
        }

        while(n%3==0){
            n/=3;
        }
        return n==1;
    }
}
