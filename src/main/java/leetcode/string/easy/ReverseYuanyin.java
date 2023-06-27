package leetcode.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/14 16:02
 * ReverseYuanyin类
 */
public class ReverseYuanyin {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int len = chars.length;
        int right = len - 1;
        while (left<right){
            while (left<len && !isVowel(chars[left])){
                left++;
            }
            while ((right>0 && !isVowel(chars[right]))){
                --right;
            }
            if (left<right){
                swap(chars,left,right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
