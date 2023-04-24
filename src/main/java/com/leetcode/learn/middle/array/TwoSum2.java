package main.java.com.leetcode.learn.middle.array;

import java.util.HashMap;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/22 10:25
 * Description:
 * Version: 1.0.0
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]),i+1};
            }else{
                map.put(target-numbers[i],i+1);
            }
        }
        return new int[0];
    }
    public static int[] twoSumDoublePoint(int[] numbers, int target) {
        int n = numbers.length;
        int slow = 0;int fast = n-1;
        while (slow<fast){
            if (target-numbers[slow]>numbers[fast]){
                slow++;
            }else if (target-numbers[slow]<numbers[fast]){
                fast--;
            }else{
                return new int[]{slow+1,fast+1};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        twoSumDoublePoint(new int[]{2,7,11,15},9);
    }
}
