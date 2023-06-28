package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/28 10:43
 * CompressString类
 */
public class CompressString {
    //public static int compress(char[] chars){
    //    if (chars.length==1){
    //        return 1;
    //    }
    //    StringBuilder sb = new StringBuilder();
    //    for(int i=0;i<chars.length;){
    //        char c = chars[i];
    //        int count = 0;
    //        while (i<chars.length && chars[i]==c){
    //            i++;
    //            count++;
    //        }
    //        sb.append(c).append(count+"");
    //    }
    //    chars = sb.toString().toCharArray();
    //    return sb.toString().length();
    //}

    public static int compress(char[] chars) {
        // 双指针问题 一个控制读取的位置 一个控制写入
        int p = 0, q = 0, n = chars.length;
        while (q < n) {
            char cur = chars[q];
            int cnt = 0;
            while(q < n && chars[q] == cur) {
                cnt ++;
                q ++;
            }
            chars[p++] = cur;
            if (cnt != 1) {
                // 将的到的数字挨个写入
                char[] counter = (cnt + "").toCharArray();
                for (char c : counter) {
                    chars[p++] = c;
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        compress(new char[]{'a','a','b','b','c','c','c'});
    }
}
