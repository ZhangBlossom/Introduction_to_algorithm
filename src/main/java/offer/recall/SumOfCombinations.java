package offer.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/7/10 20:14
 * SumOfCombinations类
 */
public class SumOfCombinations {
    //public List<List<Integer>> combinationSum3(int k, int n) {
    //    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    //    boolean[] booleans = new boolean[arr.length];
    //    List<List<Integer>> res = new ArrayList<>();
    //    List<Integer> list = new ArrayList<>(k);
    //    recall(arr, booleans, res, list, n, k,0);
    //    return res;
    //}
    //
    //private void recall(int[] arr, boolean[] booleans, List<List<Integer>> res, List<Integer> list, int n, int k,
    //                    int index) {
    //    if (list.size()== k && n==0){
    //        res.add(list);
    //        return;
    //    }else if(list.size() == k){
    //        return ;
    //    }else{
    //        for (int i = 0; i < arr.length; i++) {
    //            if (booleans[i]){
    //                continue;
    //            }
    //            list.add(arr[i]); //1
    //            booleans[i]=true;
    //            recall(arr,booleans,res,list,n-arr[i],k,index+1);
    //            booleans[i]=false;
    //            list.remove(index);
    //        }
    //    }`
    //}
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < (1 << 9); mask++) {
            if (check(mask, n, k)) {
                res.add(new ArrayList<>(ans));
            }
        }
        return res;
    }

    private boolean check(int mask, int n, int k) {
        ans.clear();
        for (int i = 0; i < 9; i++) {
            if ((mask & (1 << i)) != 0) {
                ans.add(i + 1);
            }
        }
        if (ans.size() != k) {
            return false;
        }
        int sum = 0;
        for (Integer an : ans) {
            sum += an;
        }
        return sum == n;
    }
}
