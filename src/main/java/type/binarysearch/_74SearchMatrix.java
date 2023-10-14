package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/14 12:39
 * _74SearchMatrix类
 */
public class _74SearchMatrix {

    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int left = 0;
    //     int right = m*n-1;
    //     while(left<=right){
    //         int mid = (right-left)/2+left;
    //         int x = matrix[mid/n][mid%n];
    //         if(x<target){
    //             left = mid+1;
    //         }else if(x>target){
    //             right = mid-1;
    //         }else{
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public static  boolean searchMatrix(int[][] matrix, int target) {
        //首先搜索应该在第一列中的哪一行中去进行搜索
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public static int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
