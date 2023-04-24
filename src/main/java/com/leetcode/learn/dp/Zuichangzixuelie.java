package main.java.com.leetcode.learn.dp;

import java.util.HashMap;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/5 19:35
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
//https://www.bilibili.com/video/BV1AB4y1w7eT/?spm_id_from=333.337.
// search-card.all.click&vd_source=1d4d63e205b3ad352b4771f87295d16d
public class Zuichangzixuelie {
    private static HashMap<Integer,Integer> map =new HashMap<>();
    //region 暴力计算就是吧代码中和hashmap有关的数据全都删掉
    //就是暴力搜索了
    //而动态规划就是记忆化搜索 也就是他要求用到你之前其实已经计算过的数据
    //是一个很经典的空间换时间的算法
    public static int getMaxLength(int[]nums){
        int max_len = 0;
        for(int i=0;i<nums.length;i++){
            max_len=Math.max(max_len, L(nums,i));
        }
        return max_len;
    }
    public static int L(int[]nums,int i){
        if(map.containsKey(i)){
            return map.get(i);
        }
        if (i==nums.length-1){
            return 1;
        }
        int max_len=1;
        for(int j=i+1;j<nums.length;j++){
            if (nums[j]>nums[i]){
                max_len = Math.max(max_len,L(nums,j)+1);
            }
        }
        map.put(i,max_len);
        return max_len;
    }
    //endregion

    public static void main(String[] args) {
        System.out.println(getMaxLength(new int[]{1, 5, 2, 4,3}));
    }
}
