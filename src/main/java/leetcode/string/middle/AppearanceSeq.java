package leetcode.string.middle;

/**
 * @author: 张锦标
 * @date: 2023/6/27 20:31
 * AppearanceSeq类
 */
public class AppearanceSeq {
    public static String countAndSay(int n){
        String s ="1";
        if (n==1){
            return s;
        }
        for(int k=0;k<n-1;k++){
            StringBuilder sb = new StringBuilder();
            for(int i=0,j=0;i<s.length();){
                while (j<s.length()&&s.charAt(i)==s.charAt(j)){
                    j++;
                }
                sb.append(j-i).append(s.charAt(i));
                i=j;
            }
            s=sb.toString();
        }

        return s;
    }
}
