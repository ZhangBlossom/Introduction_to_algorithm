package main.java.com.leetcode.learn.easy.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/30 15:41
 * Description:
 * ѡ������Ҳ���ڲ�����
 * ѡ�������˼·��ÿһ�ζ�����������ά����
 * Ȼ������ҳ���С������,�뵱ǰ���ѭ����Ӧ��i�����ݽ���λ��(ע���ǽ���λ��)
 * ����i=2 Ȼ��Ҫ��������10������� ��ô��ʱarr[2]=10 arr[10ԭ��λ��]=arr[2]
 * ÿ�ο�ͷ��λ�ö���+1��Ҳ����һ����0 ֮����1 2 3...
 */
public class SelectionSort {
    public static void selectionSort(int[]arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int p = i; //��p�ȸ�ֵΪi �������Է�ֹ����û�н���if��������p��֮ǰ��ֵ
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { //�����ҵ���Сֵ����λ��
                    min = arr[j];
                    p = j;
                }
            }
            if (p != i) { //���p���ǵ�ǰλ�õ����ݾͽ����޸�
                arr[p] = arr[i];//�����־λ������ҪŶ
                arr[i] = min;
            }
            System.out.println("��"+(i+1)+"�ֽ����"+ Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5412, 12, 3, 513, -1, 6, 123,123,234,5345,-324};
        selectionSort(arr);
    }
}
