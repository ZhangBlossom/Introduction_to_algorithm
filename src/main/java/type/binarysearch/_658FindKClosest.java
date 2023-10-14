package type.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/10/14 17:01
 * _658FindKClosest类
 */
public class _658FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}
