package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/17 19:53
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1]; //所以直接把第一位设置为1 其他位置使用默认值0即可
        //这里用来判断全是9的情况
        digits[0] = 1;
        return digits;
    }

    public static int[] myPlusOne(int[] digits) {
        int len = digits.length;
        boolean flag = false; //表示是否进位
        for (int i = len - 1; i >= 0; i--) {//9 9
            if (flag) { //如果有进位那么进行进位
                digits[i]++;
                if (digits[i] == 10) { //如果进位之后触发连续进位
                    flag = true; //那么下一次应该不要再走下面的判断了
                    digits[i] = 0;
                } else {
                    return digits;
                }
            }
            if (!flag) { //第一次循环走这里
                int cur = digits[i] + 1;
                if (cur == 10) {
                    flag = true;
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
        }
        digits = new int[len+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        myPlusOne(new int[]{9,9});
    }
}
