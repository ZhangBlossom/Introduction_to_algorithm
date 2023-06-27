package leetcode.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/13 14:43
 * ExcelColumOrder类
 */
public class ExcelColumOrder {
    public static int titleToNumber(String columnTitle) {
        int first = (int) (columnTitle.charAt(columnTitle.length() - 1) - 'A' + 1);
        if (columnTitle.length() == 1) {
            return first;
        }
        int length = columnTitle.toCharArray().length;
        int sum = first;
        for (int i = 1; i <= length - 1; i++) {
            int base = (int) Math.pow(26, i );
            int num = (columnTitle.charAt(length - i - 1) - 'A' + 1);
            sum += base*num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
