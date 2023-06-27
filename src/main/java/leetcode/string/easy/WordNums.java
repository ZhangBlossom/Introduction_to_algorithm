package leetcode.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/17 10:54
 * WordNums类
 */
public class WordNums {
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
