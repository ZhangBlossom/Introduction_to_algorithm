package offer;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/1 13:11
 * SimilarStr类
 */
public class SimilarStr {
    public boolean closeStrings(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        if (m!=n){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<m;i++){
            arr1[i] = str1.charAt(i);
            arr2[i] = str2.charAt(i);
        }
        for(int i=0;i<m;i++){
            if (arr1[i]==0 && arr2[i]>0){
                return false;
            }
            if (arr2[i]==0 && arr1[i]>0){
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<m;i++){
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
