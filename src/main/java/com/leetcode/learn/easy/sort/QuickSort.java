package main.java.com.leetcode.learn.easy.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/31 13:54
 * Description:
 * �������� �ҵ�һ������ ���������С������ �ұߴ�������
 * Ȼ�����ߵ��ٴΰ�����ķ�������
 */
public class QuickSort {
    public static void quickSort(int[]arr,int left,int right){
        int l=left;//���±�
        int r=right;//���±�
        //pivot����ֵ
        int pivot=arr[(left+right)/2];
        //whileѭ����Ϊ�������С��pivot �ұߴ���pivot
        while(l<r){//���±껹С�����±�
            while(arr[l]<pivot){//��pivot���һֱ�� ֱ���ҵ������ݴ���pivot�˳�
                l++;
            }//�˳�ʱarr[l]>=pivot
            while(arr[r]>pivot){//��pivot�ұ�һֱ�� ֱ���ҵ���pivotС���˳�
                r--;
            }//�˳�ʱarr[r]>pivot
            if(l>=r){
                break;//������������Ѱ�ҷ���ʹ��l>=r˵����ߵ��Ѿ���С��pivot
                //�ұߵĶ�����pivot��
            }
            //���û�г��� ��ô�ͽ�����ʱ����ֵ����ֵ ��Ϊ���ǲ�����
            arr[l]^=arr[r];
            arr[r]^=arr[l];
            arr[l]^=arr[r];
            //������lָ��arr[r] rָ��arr[l]
            //���������arr[l]==pivot ��ôr--
            if(pivot==arr[l]){//arr[l]==pivot˵��֮ǰ��rָ����pivot ��ô֮��r��������
                r--;
            }
            if(pivot==arr[r]){//��֮����
                l++;
            }
        }
        //���l==r ����l++��r-- ����ջ���
        if(l==r){
            l++;
            r--;
        }
        //����ݹ�
        if(left<r){
            quickSort(arr,left,r);
        }
        //���ҵݹ�
        if(right>l){
            quickSort(arr,l,right);
        }
    }
    public static void main(String[] args) {
        int[]arr={1,123,5,3425,2130,-4365,-123};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
 