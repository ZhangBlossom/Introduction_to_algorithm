package main.java.com.leetcode.learn.easy.array;

import java.util.Arrays;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/13 13:57
 * Description: 
 * Version: 1.0.0
 * 455
 */
public class DistributeBiscuits {
    public int findContentChildren(int[] g, int[] s) {
        // 将胃口和饼干排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 孩子的数量
        int n = g.length;
        // 饼干的数量
        int m = s.length;
        // 记录结果
        int res = 0;
        for(int i = 0; i < m; i++){
            // 从胃口小的开始喂
            if(res < n && g[res] <= s[i]){
                res += 1;
            }
        }
        return res;
    }

}
