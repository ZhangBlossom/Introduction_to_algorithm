package leetcode.easy.array;

import java.util.TreeSet;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/8 9:26
 * Description:
 * Version: 1.0.0
 */
public class ThirdBigNumber {
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }

    public static void main(String[] args) {
        thirdMax(new int[]{1,2,-2147483648});
    }
}
