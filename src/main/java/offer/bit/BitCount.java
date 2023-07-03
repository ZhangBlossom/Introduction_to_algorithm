package offer.bit;

/**
 * @author: 张锦标
 * @date: 2023/7/2 12:00
 * BitCOunt类
 */
public class BitCount {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++){
            int j = i;
            while(j>0){
                if (j%2>0){
                    arr[i]++;
                }
                j/=2;
            }
        }
        return arr;
    }
}
