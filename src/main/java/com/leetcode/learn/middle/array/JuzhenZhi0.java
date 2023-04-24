package main.java.com.leetcode.learn.middle.array;


import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/2/27 9:44
 * JuzhenZhi0类
 */
public class JuzhenZhi0 {
    public static void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<matrix.length;i++){
            List<Integer> list = new ArrayList<>();
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    if (map.containsKey(i)){
                        list = map.get(i);
                        list.add(j);
                        map.put(i,list);
                    }else{
                        list.add(j);
                        map.put(i,list);
                    }
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            for (int i=0;i<matrix[key].length;i++){//取出的是列数 行变0
                matrix[key][i]=0;
            }
            for (Integer integer : value) {
                for (int i=0;i< matrix.length;i++){//行数
                    matrix[i][integer]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][]matrix = new int[][]{
                {1,0,0},
                {0,0,0},
                {1,0,0}
        };
        setZeroes(matrix);
    }
}
