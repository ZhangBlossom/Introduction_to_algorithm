package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/20 16:27
 * ReverseLeftWords类
 */
public class ReverseLeftWords {
    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, n);
        reverse(chars, n, chars.length);
        reverse(chars, 0, chars.length);
        return new String(chars);
    }

    private static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void reverse(char[] chars, int begin, int end) {
        //由于end本身就是不被包含的 所以end-begin<=1意味着压根就没有要反转的字符串
        if (end - begin <= 1) {
            return;
        }
        //需要反转的索引位置j是end-1，end是右边界，是开区间
        int j = end - 1;
        for (int i = begin; i < (begin + end) / 2; i++) {
            swap(chars, i, j--);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}

