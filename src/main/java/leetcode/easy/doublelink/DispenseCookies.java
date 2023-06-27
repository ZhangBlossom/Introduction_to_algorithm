package leetcode.easy.doublelink;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/5/30 16:04
 * DispenseCookies类
 */
public class DispenseCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int m = g.length;
        int n = s.length;
        for(int i=0,j=0;i<m && j< n;i++,j++){
            while (j<n && g[i]>s[j]){
                j++;
            }
            if (j<n){
                count++;
            }
        }
        return count;
    }
}
