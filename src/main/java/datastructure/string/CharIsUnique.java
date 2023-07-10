package datastructure.string;

import sun.misc.ObjectInputFilter;

/**
 * @author: 张锦标
 * @date: 2023/5/25 12:09
 * CharIsUnique类
 * 当前类用于判断字符串中的所有字符是否只出现一次
 * 并且保证了额外空间占用为O(1)
 * 使用的是非递归堆排序
 */
public class CharIsUnique {
    public static boolean isUniqueBasic(String str){
        if (str==null || str.equals("")){
            return false;
        }
        boolean [] chars = new boolean[256];
        for(int i=0;i<str.toCharArray().length;i++){
            if (chars[str.charAt(i)]){
                return false;
            }
            chars[str.charAt(i)]=true;
        }
        return true;
    }

    public static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        if (chars == null) {
            return true;
        }
        headSort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void headSort(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            //构造大顶堆
            heapInsert(chars, i);
        }
        //开始使用堆排序
        for (int i = chars.length - 1; i > 0; i--) {
            swap(chars, 0, i);
            heapify(chars, 0, i);
        }
    }

    /**
     * 当前方法用于不断的构造一个大顶堆
     *
     * @param chars
     * @param i
     */
    private static void heapInsert(char[] chars, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (chars[parent] < chars[i]) {
                swap(chars, parent, i);
                i = parent;
            } else {
                break;
            }
        }

    }

    private static void heapify(char[] chars, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            if (chars[left] > chars[i]) {
                largest = left;
            }
            if (right < size && chars[right] > chars[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(chars, largest, i);
            } else {
                break;
            }
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }

    private static void swap(char[] chars, int i, int i1) {
        char temp = chars[i];
        chars[i] = chars[i1];
        chars[i1] = temp;
    }


    public static void main(String[] args) {
        System.out.println(isUnique("abcda"));
    }
}
