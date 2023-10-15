package datastructure.bit;

/**
 * @author: 张锦标
 * @date: 2023/10/14 21:11
 * OddTimesNum2类
 * 有两个数据出现了奇数次，
 * 其他数据都出现了偶数次，找出这两个出现了
 * 奇数次的数据
 */
public class OddTimesNum2 {
    public static void printOddTimesNumb2(int[]arr){
        int eor = 0;
        for(int i = 0;i<arr.length;i++){
            eor^=arr[i];
        }
        //eor = a^b;
        //eor != 0
        //eor中必须有一个位上位1，因为如果都为0就是0了
        //得到最右边上面的哪一个为1的位
        int rightOne = eor & ~(eor+1);
        int onlyOne = 0; //eor'
        //此时对于a和b，由于他们至少在一个位上不同，那么我们就针对这个位
        //因为其他数据出现偶数次，所以让他们参与异或运算不会影响结果
        //此时我们只针对这个位为1的数据，而a和b中只能有一个数据在这个位上为1，因为如果
        //他们都为1，那么就得到0了，不合理，所以这里我们选择eor上面最右边的那个为1的位进行与运算
        //就能得到最后的onlyOne就是a或者b
        for(int cur:arr){
            if (((cur&rightOne)==1)){
                onlyOne^=cur; //假设得到a
            }
        }
        //得到a或者b之后，我们再一次异或，就是对方了。
        //那么这里就是b
        System.out.println(onlyOne+"  "+(eor^onlyOne));
    }
}
