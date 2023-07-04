package offer.doublelink;

/**
 * @author: 张锦标
 * @date: 2023/6/28 11:31
 * isSubSeq类
 */
public class isSubSeq {
    public boolean isSubsequence(String s,String t){
        int i=0;
        int j=0;
        while (i<s.length() && j<t.length()){
            if (s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return s.length()==i;
    }
}
