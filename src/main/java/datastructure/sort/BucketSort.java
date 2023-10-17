package datastructure.sort;

import java.util.ArrayList;

/**
 * @author: Serendipity
 * Date: 2022/2/6 14:24
 * Description:
 */
public class BucketSort {

    public static void sort(ArrayList<Integer> list, int i) {
        if (list == null) {
            list.add(i);
        } else {
            int flag = list.size() - 1;
            while (flag >= 0 && list.get(flag) > i) {
                if (flag + 1 >= list.size()) {
                    list.add(list.get(flag));
                } else {
                    list.set(flag + 1, list.get(flag));
                }
                flag--;
            }
            if (flag != (list.size() - 1)) {
                list.set(flag + 1, i);
            } else {
                list.add(i);
            }
        }
    }

    public static void bucketSort(int[] num, int bucketNum) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            min = min <= num[i] ? min : num[i];
            max = max >= num[i] ? max : num[i];
        }

        double size = (double) (max - min + 1) / bucketNum;
        ArrayList<Integer>[] list = new ArrayList[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println("Ԫ��:" + String.format("%-2s", num[i]) + ", �����䵽" + (int) ((num[i] - min) / size) +
                    "��Ͱ");
//            sort(list[(int) ((num[i] - min) / size)], num[i]);
            list[(int) ((num[i] - min) / size)].add(num[i]);
        }
        for (int i = 0; i < list.length; i++) {
            list[i].sort(Integer::compare);
        }
        System.out.println();
        for (int i = 0; i < bucketNum; i++) {
            System.out.println(String.format("%-1s", i) + "��Ͱ������:" + list[i]);
        }
        System.out.println();

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
        bucketSort(num, 3);
        long endTime = System.currentTimeMillis();
        System.out.println("��������ʱ�䣺 " + (endTime - startTime) + "ms");
    }

}
