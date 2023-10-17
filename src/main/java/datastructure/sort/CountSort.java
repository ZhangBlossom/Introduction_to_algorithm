package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/2 13:48
 * Description:
 */
public class CountSort {
    public static void countSort(int[]arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]<min){
//                min=arr[i];
//            }
//            if(arr[i]>max){
//                max=arr[i];
//            }
//        }
        for (int i : arr) {
            min=Math.min(i,min);
            max=Math.max(i,max);
        }
        int index=0;
        int elementCount[]=new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            elementCount[arr[i]-min]++;
        }
        for(int i=0;i< elementCount.length;i++){
            if (elementCount[i]!=0) {
                for(int j=0;j<elementCount[i];j++){
                    arr[index++]=i+min;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        countSort(new int[]{0, -1, 9, 3, 2, 1, 8, 6, 5, 10});
    }
}
