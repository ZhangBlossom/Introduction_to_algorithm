package leetcode.bit.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/9 9:53
 * BitOneNums类
 */
public class BitOneNums {

    //计算一个int类型中1的个数
    public static int hammingWeight(int n){
        int count=0;
        for(int i=0;i<32;i++){
            if((n&1)==1){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(11));
    }
}
