package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/1 21:02
 * Description:
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        // 找到数组中的最大值，以确定最大元素的位数
        int max = arr[0];
        int maxLength = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        maxLength = (max + "").length(); // 最大元素的位数

        // 创建桶数组，用于存储排序中间结果
        int[][] bucket = new int[10][arr.length]; // 每个桶最多能容纳数组大小个元素
        int[] bucketCount = new int[10]; // 记录每个桶中的元素个数
        int digitOfElement = 0;

        // 进行多轮排序，每轮排序根据元素的位数
        for (int i = 0, n = 1; i < maxLength; n *= 10, i++) {
            // 将元素按照当前位数的值放入对应桶中
            for (int j = 0; j < arr.length; j++) {
                digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketCount[digitOfElement]] = arr[j];
                bucketCount[digitOfElement]++;
            }

            int index = 0;
            // 依次从桶中取出元素，按照顺序重组数组
            for (int k = 0; k < bucketCount.length; k++) {
                if (bucketCount[k] != 0) {
                    for (int l = 0; l < bucketCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketCount[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }



    public static void radixSortX(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        //有多少个数就准备多大的空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {//有多少位就进出多少次
            //10个空间
            //count[0] 当前位是0的数字有多少个
            //count[1] 当前位是0和1的数字有多少个
            //count[2] 当前位是0，1，2的数字有多少个
            int[] count = new int[radix];//count[0...9]
            for (j = L; j <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (j = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5412, 12, 3, 513, 0, 6, 324};
        //radixSort(arr);
        radixSortX(arr, 0, arr.length - 1, maxBits(arr));
        System.out.println(Arrays.toString(arr));
    }
}
