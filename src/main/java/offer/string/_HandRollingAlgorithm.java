package offer.string;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/3 22:43
 * HandRollingAlgorithm类
 * 手摇算法反转部分字符串
 */
public class _HandRollingAlgorithm {
    /**
     * 手摇算法反转部分字符串
     *
     * @param arr   要反转的字符串的数组
     * @param start 开始下标（包含）
     * @param end   结束下标（不包含）
     */
    public static void reversePart(char[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int j = end - 1;
        for (int i = start; i < (start + end) / 2; i++) {
            swap(arr, i, j--);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = "1234567";
        char[] chars = s.toCharArray();
        reversePart(chars, 0, 4);
        System.out.println(Arrays.toString(chars));
        reversePart(chars, 4, chars.length);
        System.out.println(Arrays.toString(chars));
        reversePart(chars,0,chars.length);
        System.out.println(Arrays.toString(chars));

    }
}
