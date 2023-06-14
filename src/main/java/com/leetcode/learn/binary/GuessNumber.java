package com.leetcode.learn.binary;

/**
 * @author: 张锦标
 * @date: 2023/6/14 16:41
 * GuessNumber类
 */
public class GuessNumber {
    public int guessNumber(int n) {
        int left = 1; int right = n;
        while(left<right){
          int num = (left+right)/2;
          if(guess(num)<=0){
              right = num;
          }else {
              left = num+1;
          }
        }
        return left;
    }

    public int guess(int num){
        int pick = 10;
        if(num==pick){
            return 0;
        }else if(num<pick){
            return 1;
        }else {
            return -1;
        }
    }
}
