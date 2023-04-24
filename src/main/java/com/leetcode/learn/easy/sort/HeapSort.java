package main.java.com.leetcode.learn.easy.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/2 13:49
 * Description:
 * ʹ�ö�������Ҫ�˽������
 * ��ʵ��������Ǵ󶥶ѻ���С���� ÿ�ζ���
 * ��������С���������ƶ�����Ҷ�ӽ��λ��
 * ����������һ�����������ݽ���
 * ���ѭ�������Ϳ��Եõ�һ�������
 * �����ò�ֽģ��һ�¶�����Ĺ���
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 10, 4, 7, 3, 4};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        //���������й�����һ���󶥶ѻ���С����
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("��ʼ����󶥶�" + Arrays.toString(arr));
        //���Զ�Ԫ����ĩβԪ�ؽ��н��� ��������ݳ���ĩβ
        //���µ����ṹ ʹ������Ѷ��� Ȼ�����������ǰ��ĩβԪ��
        for (int j = arr.length - 1; j > 0; j--) {
            arr[j] ^= arr[0]; //����
            arr[0] ^= arr[j];
            arr[j] ^= arr[0];
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    ����������
     * @param i      ��ǰ��Ҷ�ӽ���������е�����
     * @param length ��ǰ�ɲ������ݵĳ��� ���ڴ󶥶������������������֮��ͻᱻ�������ڲ���
     *               ���length--
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //����ǰ��Ҷ�ӽ�㱣��
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {//k=2*i+1��k������ǵ�ǰ��Ҷ�ӽ�������
            if (k + 1 < length && arr[k] < arr[k + 1]) {//�ж����Ӵ����Һ��Ӵ�
                k++;//������Һ��Ӵ��++��õ��Һ��ӵ�����
            }
            if (arr[k] > temp) {//�жϺ��Ӵ��ǵ�ǰ����
                arr[i] = arr[k]; //�������������
                i = k; //���Ԫ�ؾ��ܵ��˷�Ҷ�ӽ�������ȥ Ȼ����iȥ��С���ݵ�����
            } else {
                break;//����i�Ǵ������ϵ� ���������ǰ�ķ�Ҷ�ӽ�����ֱ���˳��ͺ� ��Ϊ������һ��
                //4��8������ȫ������ ��ôi=3һ��ʼ Ȼ��arr[7]<arr[3]��ôֱ��break��
                //��һ��i=2(i=3�Ǹ�����˫�׽��) Ȼ��i=1 i=0
            }
        }
        arr[i] = temp;//������ݱ�����ȥ�� ������ԭ��λ�õ����ݻ�û�б��޸�
    }   //�����һ����������Ϊ���޸��Ǹ�����
}
