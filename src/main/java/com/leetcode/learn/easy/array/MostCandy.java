package com.leetcode.learn.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/7 9:24
 * MostCandy类
 */
public class MostCandy {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> result  = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy>max){
                max = candy;
            }
        }
        for (int candy : candies) {
            if (candy+extraCandies>=max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}
