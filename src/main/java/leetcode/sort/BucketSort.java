package leetcode.sort;

import java.util.ArrayList;

/**
 * @author: Serendipity
 * Date: 2022/2/6 14:24
 * Description:
 */
public class BucketSort {
    //����һ�㲻ʹ��Ͱ�������ʹ��Ͱ���������
    //�����������ͼ������� ��ΪͰ������Ҫ�ٶ�ÿ��Ͱ�е����ݽ���һ������
    //�������ʹ�ö�ά����ȥ��Ͱ ��ô�������ǲ�ȷ��ÿ��Ͱ�е����ݻ��ж���
    //����ɿռ��ϵ��˷� �������鿪�ٵĿռ���ȷ���� ��ô�͵��¿�������ʱ��Ĭ��
    //λ�õ�Ԫ����0 null 0.0 ��ЩĬ��ֵ ��ô��ЩĬ��ֵҲ���������
    //������ǻ���Ҫ��Ͱ��ÿ����������Ҫ�����Ԫ�ؽ��м���
    //Ҳ���ǻ���Ҫ��һ������Ͱ�����ݵ�Ͱ
    //����������ʱ��Ч�ʷ���Խ��Խ��
    //����ֱ��ʹ��ArrayList ����arraylist�����ݵ�ʱ��Ҳ����Ҫ�����ʱ���
    //������� ����һ�㲻ʹ��Ͱ����
    //�����������Ԫ�ص�ͬʱ��Ҫ����Ԫ�ص�����
    public static void sort(ArrayList<Integer> list, int i) {
        if (list == null)
            list.add(i);
            //������õ�����ʽΪ��������
        else {
            int flag = list.size() - 1;
            while (flag >= 0 && list.get(flag) > i) {
                if (flag + 1 >= list.size())
                    list.add(list.get(flag));
                else
                    list.set(flag + 1, list.get(flag));
                flag--;
            }
            if (flag != (list.size() - 1))
                //ע��������flag+1,�Լ����Գ��Խ����ﻻ��flag����,���������Խ������
                list.set(flag + 1, i);
            else
                list.add(i);
        }
    }

    public static void bucketSort(int[] num, int bucketNum) {
        //�����õ������е����ֵ����Сֵ
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            min = min <= num[i] ? min : num[i];
            max = max >= num[i] ? max : num[i];
        }
        //���ÿ��Ͱ�ĳ���,�������ʹ��Double
        double size = (double) (max - min + 1) / bucketNum;
        ArrayList<Integer>[] list = new ArrayList[bucketNum];
        for (int i = 0; i < bucketNum; i++) { //�����Ƕ������� �����Ҫ������ÿ�������ȳ�ʼ��
            list[i] = new ArrayList<Integer>();
        }
        //��ÿ��Ԫ�ط����Ӧ��Ͱ֮��ͬʱ����Ͱ��Ԫ�ص�����
        for (int i = 0; i < num.length; i++) {
            System.out.println("Ԫ��:" + String.format("%-2s", num[i]) + ", �����䵽" + (int) ((num[i] - min) / size) + "��Ͱ");
//            sort(list[(int) ((num[i] - min) / size)], num[i]);
            list[(int) ((num[i] - min) / size)].add(num[i]);
        }
        for(int i=0;i<list.length;i++){
            list[i].sort(Integer::compare);
        }
        System.out.println();
        for (int i = 0; i < bucketNum; i++) {
            System.out.println(String.format("%-1s", i) + "��Ͱ������:" + list[i]);
        }
        System.out.println();
        //˳���������Ͱ,�ó����� �Ѿ�����ŵ�����
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
            }
        }
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {

        int[] num = {7, 4, 9, 3, 2, 1, 8, 6, 5, 10};
        long startTime = System.currentTimeMillis();
        //����Ͱ�������������Լ�����,�����ҾͶ������3
        bucketSort(num, 3);
        long endTime = System.currentTimeMillis();
        System.out.println("��������ʱ�䣺 " + (endTime - startTime) + "ms");
    }

}
