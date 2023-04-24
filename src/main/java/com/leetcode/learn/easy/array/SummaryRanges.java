package main.java.com.leetcode.learn.easy.array;

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
}
