package type.binarysearch;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/10/14 15:31
 * _274Hindex类
 */
public class _274Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int left = 0;
        int right = citations.length - 1;
        int len = citations.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (len - mid <= citations[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
