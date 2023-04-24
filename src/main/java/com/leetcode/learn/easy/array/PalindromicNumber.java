package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/11 20:27
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * p9
 * 回文数字？
 */
public class PalindromicNumber {
//    public static boolean isPalindrome(int x) {
//        if (x<0){
//            return false;
//        }
//        if (x==0){
//            return true;
//        }
//        int y=0;
//        String s = "";
//        while (x>0){
//            y=x%10;
//            x/=10;
//            s+=y+"";
//        }
//        System.out.println(s);
//        for(int i=0,j=s.length();i<s.length()/2;i++,j--){
//            if(s.charAt(i)!=s.charAt(j-1)){
//                return false;
//            }
//        }
//        return true;
//    }

    //    public static boolean isPalindrome(int x) {
//        if (x<0){
//            return false;
//        }
//        if (x==0){
//            return true;
//        }
//        int y=0;
//        String s = x+"";
//        for(int i=0,j=s.length();i<s.length()/2;i++,j--){
//            if(s.charAt(i)!=s.charAt(j-1)){
//                return false;
//            }
//        }
//        return true;
//    }

    //    public static boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        if (x == 0) {
//            return true;
//        }
//        String s = x + "";
//        int length = s.length();
//        String s1 = s.substring(0, s.length() / 2); //获取前一半
//        if (length % 2 == 0) {
//            StringBuffer sb = new StringBuffer(s.substring(length/2));
//            if (s1.equals(sb.reverse().toString())) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            StringBuffer sb = new StringBuffer(s.substring(length/2+1));
//            if (s1.equals(sb.reverse().toString())) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
//    public static boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        if (x == 0) {
//            return true;
//        }
//        String s = x+"";
//        StringBuffer sb = new StringBuffer(s);
//        if (s.equals(sb.reverse().toString())){
//            return true;
//        }else{
//            return  false;
//        }
//    }
    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }


        public static void main (String[]args){
            isPalindrome(1001);
        }
    }
