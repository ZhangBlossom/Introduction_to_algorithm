package leetcode.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/2 13:48
 * Description:
 * �����������ȶ��� ,������Ӧ���ܺ����ԵĿ�����,��Ϊ�������������ǻ��ڱȽϵ��㷨.
 * ����������Ҫ�Ķ���ռ�Ƚϴ�,�����Һ����ԵĿ�����,���ҿռ��˷ѵ����Ҳ��Ƚ�����,
 * ��Ϊһ��������MAX��MIN�Ĳ�����,��ô��Ҫ���ڴ�ռ�ͻ�ǳ���.���Ҽ��������е�Ԫ��
 * ����ɢ����һ���ض���������,��ô�ڴ�ռ��˷ѵ����Ҳ��ǳ�����.
 */
public class CountSort {
    public static void countSort(int[]arr){
        int max=Integer.MIN_VALUE;//�������������ֵ
        int min=Integer.MAX_VALUE;//������������Сֵ
//        for(int i=0;i<arr.length;i++){//ȡ�������е��������Сֵ
//            if(arr[i]<min){
//                min=arr[i];
//            }
//            if(arr[i]>max){
//                max=arr[i];
//            }
//        }//�����һ����������,��ô��֪����������е��������С����(ͨ��ɢ��)
        for (int i : arr) {
            min=Math.min(i,min);
            max=Math.max(i,max);
        }
        int index=0;
        int elementCount[]=new int[max-min+1];//���ǾͿ��������ǵĲ����õ��������������ж��ٸ�����
        for(int i=0;i<arr.length;i++){//������С������3 ��ô�����±�0->3 1->4�Դ�����
            elementCount[arr[i]-min]++;//��Ӧ������λ�õ�������+1
        }
        for(int i=0;i< elementCount.length;i++){
            if (elementCount[i]!=0) {//�����ǰ����λ�������� ��ô��˵��������ִ���
                for(int j=0;j<elementCount[i];j++){
                    arr[index++]=i+min;//��ô�Ͱ�������ݸ��ǵ�ԭ������ȥ
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        countSort(new int[]{0, -1, 9, 3, 2, 1, 8, 6, 5, 10});
    }
}
