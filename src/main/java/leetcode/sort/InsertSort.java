package leetcode.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/30 17:25
 * Description:
 * ��������:
 * ÿ�ζ��жϵ�ǰ������ǰ��һ�������Ƿ�λ�ò���
 * ������� ��ô����ǰ��������Ϊ�ڱ��ڵ�
 * Ȼ���ٵ�ǰ�����±�-1��ʼ���� ������ֱ��arr[0]>arr[i]Ϊֹ
 * �����ǰѭ��arr[0]<arr[i]��ôִ��arr[i+1]=arr[i]
 * Ҳ���ǽ�������ݺ��� Ϊ�����С������arr[0]��׼��
 * ���һ���˳�֮������ִ����i--�������˳�
 * �����˳�ʱ��ǰһ��λ�þ���arr[0]Ӧ�ò����λ��
 */
public class InsertSort {
    private static int[] arr = new int[]{0,3, 5412, 12, 3, 513, -1, 6, -324};
    public static void insertSort(int[]arr){
        int i,j;
        for(i=2;i<arr.length;i++){
            if(arr[i-1]>arr[i]){//���ǰ������ݸ���˵����ǰ��Ҫ����
                arr[0]=arr[i]; //i�Ǹ�С������  �ڱ��ڵ�
                for(j=i-1;arr[j]>arr[0];j--){//�ҵ�С����Ӧ�ò����λ��
                    arr[j+1]=arr[j]; //arr[0]��ʱ���Ǵ����������
                    //��ʱ��ҪѰ��arr[0]Ӧ�ò����λ�� ��˰Ѹ�������ݶ����Ƹ�arr[0]��λ��
                }//�˳�ѭ��˵��j��Ӧ��λ�ñȴ��������ݻ�С ��ʱ����Ӧ�ò������λ��֮��һ��λ��
                arr[j+1]=arr[0];
                System.out.println("��"+(i-1)+"������λ��Ϊ"+ Arrays.toString(arr));
            }
        }
    }

    public static void main(String[] args) {
        insertSort(arr);
    }
}
