package offer.recall;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author: 张锦标
 * @date: 2023/7/16 10:10
 * Combination类
 */
public class Combination {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
    }
    public void dfs(int i,int n,int k){
        if (temp.size() + n - i +1 < k){
            return;
        }
        if (temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        //添加当前元素
        temp.add(i);
        dfs(i+1,n,k);
        //跳过当前元素
        temp.remove(temp.size()-1);
        dfs(i+1,n,k);
    }
}
