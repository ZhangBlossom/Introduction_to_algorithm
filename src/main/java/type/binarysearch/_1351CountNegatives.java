package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/12 21:31
 * _1351CountNegatives类
 */
public class _1351CountNegatives {
    class Solution {
        public int countNegatives(int[][] grid) {
            int len = grid[0].length;
            int count = 0;
            for(int[] g:grid){
                int left =0 ;
                int right = len-1;
                int pos = -1;
                while(left<=right){
                    int mid = (left+right)/2;
                    if(g[mid]<0){
                        pos = mid;
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
                count+=(pos!=-1)?(len-pos):0;
            }
            return count;
        }
    }
}
