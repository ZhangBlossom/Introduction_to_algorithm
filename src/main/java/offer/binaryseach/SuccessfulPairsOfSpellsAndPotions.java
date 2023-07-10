package offer.binaryseach;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/7/5 9:54
 * SuccessfulPairsOfSpellsAndPotions类
 */
public class SuccessfulPairsOfSpellsAndPotions {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        long[] arr=new long[potions.length];//必须要转发为long类型，不然超范围
        for (int i = 0; i < arr.length; i++) {
            arr[i]=potions[i];
        }
        for (int i = 0; i < n; i++) {
            int count = search(arr, spells[i], success);
            pairs[i] = count;
        }
        return pairs;
    }
    public static int search(long[] potions,int spell,long success){
        if(potions[potions.length-1]*spell<success){
            return 0;//对边界进行处理
        }
        int left = 0;
        int right = potions.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if ((long) potions[mid] * spell < success) {
                left = mid + 1;
            } else if ((long) potions[mid] * spell >= success) {
                right = mid;
            }
        }
        //满足要求的第一个数据的下标就是right
        return potions.length - right;
    }

    public static void main(String[] args) {
        successfulPairs(new int[]{5,1,3},new int[]{1,2,3,4,5},7);
    }
}
