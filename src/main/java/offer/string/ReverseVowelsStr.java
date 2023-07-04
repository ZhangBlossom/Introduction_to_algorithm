package offer.string;

/**
 * @author: 张锦标
 * @date: 2023/6/28 8:56
 * ReverseVowelsStr类
 */
public class ReverseVowelsStr {
    public String reverseVowels(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length -1 ;
        int len = chars.length;
        while(left<right){
            while (left<len && !isVowel(chars[left])){
                left++;
            }
            while (right>0 && !isVowel(chars[right])){
                right--;
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
