package main.java.com.leetcode.learn.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/1 20:04
 * Description:
 * �鲢�����˼·�Ƿ���,Ҳ���ǽ������Ϊ������������
 * ��������������ݹ�����
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);//����벿�ֽ�������
            mergeSort(arr, mid + 1, right, temp);//���Ұ벿�ֽ�������
            merge(arr, left, mid, right, temp);//������������������ں�
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //(һ)
        //�Ȱ��������ߵ��������ݰ��չ�����䵽temp����
        //ֱ������������һ�ߴ������
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { //�Ƚϵ�ǰarr�����е����� С���Ȳ��뵽temp��ȥ
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //(��)
        //���е�����֮��ʣ�µ�Ԫ��ֱ�Ӹ�ֵ��temp��ȥ
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //(��)
        //�ص㲿�� ��left��ʼ�ѵ�right�����ݸ��ǵ�ԭ����
        int tempLeft=left;
        t=0;
        while(tempLeft<=right){
            arr[tempLeft++]=temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 123, 53, 123, 65};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }
}
