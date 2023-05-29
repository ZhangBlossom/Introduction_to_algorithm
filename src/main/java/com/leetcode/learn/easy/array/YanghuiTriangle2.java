package com.leetcode.learn.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/27 9:59
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 119
 */
public class YanghuiTriangle2 {
    //region 滚动数组解法
    //因为只需要某一层 因此前面的几层可以直接被覆盖
    public List<Integer> getRowByRollArray(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }
    //endregion

    //region
    //当前行第i项的计算只与上一行第i-1 项及第i项有关。因此我们可以倒着计算当前行，
    // 这样计算到第i项时，第i-1项仍然是上一行的值。
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    //endregion
    public static List<List<Integer>> getYanghui(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
            result.add(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getYanghui(5));
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= 5; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

    }

}
