package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/31 12:54
 * Description:
 */
public class ShellSort {
    private int arr[];
    public void shellSort(int[]arr){
        int i,j;
        int increment=arr.length;//
        do{
            increment=increment/3+1;//
            for(i=increment+1;i<=arr.length-1;i++){
                if(arr[i]<arr[i-increment]){
                    arr[0]=arr[i];//
                    for(j=i-increment;j>0&&arr[j]>arr[0];j-=increment){//
                        arr[j+increment]=arr[j];//
                    }
                    arr[j+increment]=arr[0];
                }
            }
        }while(increment>1);
    }
    public static void main(String[] args) {
        ShellSort sh = new ShellSort();
        sh.arr=new int[]{0,8,87,7,6,54,34,123};
        sh.shellSort(sh.arr);
        System.out.println(Arrays.toString(sh.arr));
    }
}
