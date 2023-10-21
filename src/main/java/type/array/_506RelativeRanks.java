package type.array;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author: 张锦标
 * @date: 2023/10/21 17:15
 * _506RelativeRanks类
 */
public class _506RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        TreeMap<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i =0;i<score.length;i++){
            map.put(score[i],i);
        }
        String [] res = new String[map.size()];
        int i =0;
        for (Integer key : map.keySet()) {
            int index = map.get(key);
            {
                if (i == 0) {
                    res[index] = "Gold Medal";
                } else if (i == 1) {
                    res[index] = "Silver Medal";
                } else if (i == 2) {
                    res[index] = "Bronze Medal";
                } else {
                    res[index] = (i+1) + "";
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{10,3,8,9,4};
        findRelativeRanks(arr);
    }
}
