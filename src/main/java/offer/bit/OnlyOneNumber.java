package offer.bit;

/**
 * @author: 张锦标
 * @date: 2023/7/2 12:00
 * OnlyOneNumber类
 */
public class OnlyOneNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
