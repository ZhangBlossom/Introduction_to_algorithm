package offer.string;

/**
 * @author: 张锦标
 * @date: 2023/6/28 9:52
 * BigDivisorOfStr类
 */
public class BigDivisorOfStr {
    public static String gcdOfStrings(String str1, String str2){
        int n1= str1.length();
        int n2= str2.length();
        for(int i=Math.min(n1,n2);i>=1;i--){
            if (n1%i==0 && n2%i==0) {
                String X = str1.substring(0,i);
                if (check(X,str1) && check(X,str2)){
                    return X;
                }
            }
        }
        return "";
    }
    private static boolean check(String x, String str1) {
        int mod = str1.length()/x.length();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=mod;i++){
            sb.append(x);
        }
        return str1.equals(sb.toString());
    }
}
