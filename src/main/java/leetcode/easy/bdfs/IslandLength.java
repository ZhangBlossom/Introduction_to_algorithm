package leetcode.easy.bdfs;

/**
 * @author: 张锦标
 * @date: 2023/6/1 20:48
 * IslandLength类
 */
public class IslandLength {
/*
一块土地原则上会带来 4 个周长，但岛上的土地存在接壤，每一条接壤，会减掉 2 个边长。
所以，总周长 = 4 * 土地个数 - 2 * 接壤边的条数。
遍历矩阵，遍历到土地，就 land++，如果它的右/下边也是土地，则 border++，遍历结束后代入公式。

 */
    public int islanPerimeter(int[][] grid){
        int land = 0; // 土地个数
        int border = 0; // 接壤边界的条数

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        border++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        border++;
                    }
                }
            }
        }
        return 4 * land - 2 * border;
    }



}
