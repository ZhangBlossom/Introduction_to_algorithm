package keypoint.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 张锦标
 * @date: 2023/10/11 19:20
 * _331CheckPreOrderSerialize类
 * https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solutions/650583/yan-zheng-er-cha-shu-de-qian-xu-xu-lie-h-jghn/
 *
 */
public class _331CheckPreOrderSerialize {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while(i<n){
            if (stack.isEmpty()){
                return false;
            }
            if (preorder.charAt(i)==','){
                i++;
            }else if(preorder.charAt(i)=='#'){
                int top = stack.pop()-1;
                if (top>0){
                    stack.push(top);
                }
                i++;
            }else{
                //当前数据是数字
                while (i<n && preorder.charAt(i)!=','){
                    i++;
                }
                int top = stack.pop()-1;
                if (top>0){
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
