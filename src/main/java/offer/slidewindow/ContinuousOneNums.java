package offer.slidewindow;

/**
 * @author: 张锦标
 * @date: 2023/6/28 21:09
 * ContinuousOneNums类
 */
public class ContinuousOneNums {
    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int maxCount = 0;
        int curCount = 0;
        int temp = k;
        for (int j = 0; j < len; j++) {
            int i = j;
            while (i < len) {
                if (nums[i] == 1) {
                    curCount++;
                } else if (nums[i] == 0 && k > 0) {
                    curCount++;
                    k--;
                } else if (nums[i] == 0 && k <= 0) {
                    k = temp;
                    break;
                }
                i++;
            }
            maxCount = Math.max(curCount,maxCount);
            curCount=0;
        }
        return maxCount;
    }
    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
    public int longestOnes2(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) {
                K--;
            }
            if (K < 0 && A[l++] == 0) {
                K++;
            }
        }
        return r - l;
    }
    public static void main(String[] args) {
        longestOnes(new int[]{0,0,0,1},4 );
    }
}
