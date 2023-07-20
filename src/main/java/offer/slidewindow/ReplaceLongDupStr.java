package offer.slidewindow;

/**
 * @author: 张锦标
 * @date: 2023/7/19 9:23
 * ReplaceLongDupStr类
 * 424
 */
public class ReplaceLongDupStr {
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        //left:左边界，用于滑动时减去头部或者计算长度
        //right:右边界，用于加上划窗尾巴或者计算长度
        int left = 0, right = 0;
        while (right < n) {
            int indexR = s.charAt(right) - 'A';
            num[indexR]++;
            //求窗口中曾出现某字母的最大次数
            //计算某字母出现在某窗口中的最大次数，窗口长度只能增大或者不变（注意后面left指针只移动了0-1次）
            //这样做的意义：我们求的是最长，如果找不到更长的维持长度不变返回结果不受影响
            maxn = Math.max(maxn, num[indexR]);

            //长度len=right-left+1,以下简称len
            //len-字母出现最大次数>替换数目 => len>字母出现最大次数+替换数目
            //分析一下，替换数目是不变的=k,字母出现最大次数是可能变化的，因此，只有字母出现最大次数增加的情况，len才能拿到最大值
            //又不满足条件的情况下，left和right一起移动,len不变的
            if (right - left + 1 - maxn > k) {
                //这里要减的，因为left越过该点，会对最大值有影响
                num[s.charAt(left) - 'A']--;
                left++;
            }
            //走完这里的时候，其实right会多走一步
            right++;
        }
        //因为right多走一步，结果为(right-1)-left+1==right-left
        return right - left;
    }
}