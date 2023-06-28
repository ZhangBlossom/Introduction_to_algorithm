package offer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: 张锦标
 * @date: 2023/6/28 20:17
 * VowelsMaxLenStr类
 */
public class VowelsMaxLenStr {
    public int maxVowels1(String s, int k) {
        if (s.length()==0){
            return 0;
        }
        LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>(k);
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 0;
        int cur = 0;
        for(int i=0;i<len;i++){
            char c = chars[i];
            if (queue.size()>=k){
                Character character = queue.remove();
                if (isVowels(character)){
                    cur--;
                }
            }
            queue.add(c);
            if (isVowels(c)){
                cur++;
                max = Math.max(max,cur);
            }
        }
        return max;
    }
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int len = s.length();
        for(int i=0;i<k;i++){
            maxCount+=isVowel(s.charAt(i));
        }
        int curCount = maxCount;
        for(int i=k;i<len;i++){
            curCount+=isVowel(s.charAt(i))-isVowel(s.charAt(i-k));
            maxCount = Math.max(curCount,maxCount);
        }
        return maxCount;
    }
    public int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }
    public boolean isVowels(char c){
        return "aeiou".indexOf(c)>=0;
    }
}
