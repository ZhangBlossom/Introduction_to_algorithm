package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/30 15:30
 * Description:
 * ð���������ڲ�����
 * ð�����򽫻�ÿһ�ζ���ͷ��ʼ����
 * ÿһ�α���������������ݷŵ����һ��
 * ���ÿһ�ζ������ٱ���һ��Ԫ��
 */
public class BubbleSort {
    public static void bubbleSort(int[]arr){
        boolean flag = false;
        out:
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { //��С���� >��Ϊ<���ǴӴ�С
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    flag = true;
                }
            }
            if (flag == false) { //����ڲ�ѭ��һ��û�޸Ĺ�λ��˵���Ѿ�����
                break out;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5412, 12, 3, 513, -1, 6, -324};
        bubbleSort(arr);
    }
}

