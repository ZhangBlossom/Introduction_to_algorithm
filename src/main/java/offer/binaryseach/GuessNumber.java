package offer.binaryseach;

/**
 * @author: 张锦标
 * @date: 2023/7/5 9:48
 * GuessNumber类
 */
public class GuessNumber {
    int pick = 10;
    public int guessNumber(int n){
        int left = 1;
        int right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return right;
    }
    public int guess(int num){
        if (pick<num){
            return -1;
        }else if(pick == num){
            return 0;
        }else{
            return 1;
        }
    }
}
