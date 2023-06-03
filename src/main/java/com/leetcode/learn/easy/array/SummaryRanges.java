package com.leetcode.learn.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/29 10:27
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

    public static List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int low = i;
            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            StringBuilder sb = new StringBuilder(nums[low] + "");
            if (low < i) {
                sb.append("->");
                sb.append(nums[i]);
            }
            result.add(sb.toString());
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        summaryRanges1(new int[]{0, 1, 2, 4, 5, 7});
    }

}
