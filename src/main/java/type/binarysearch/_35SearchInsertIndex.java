package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/12 20:37
 * _35SearchInsertIndex类
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class _35SearchInsertIndex {
    public int searchInsert(int[]arr,int target){
        int res = arr.length;
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (target<=arr[mid]){
                right = mid - 1;
                res = mid ;
            }else{
                left = mid+1;
            }
        }
        return res;
    }
}
