package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/17 16:49
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 58
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
//        int len = s.length();
//        int count = 0;
//        boolean flag = false;
//        for (int i = len - 1; i >= 0;) {
//            if (s.charAt(i)==' ' && flag){
//                return count;
//            }
//            if (s.charAt(i) == ' '){
//                i--;
//                continue;
//            }else{
//                count++;
//                i--;
//                flag=true;
//            }
//        }
//        return count;
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("asd  day "));
    }
}
