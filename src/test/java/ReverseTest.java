/**
 * @author: 张锦标
 * @date: 2023/8/11 14:17
 * ReverseTest类
 */
public class ReverseTest {
    public static void main(String[] args) {
        int i = 121;
        String s = i+"";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse());
        System.out.println(sb);
        System.out.println(sb.toString().equals(sb.reverse()));
    }
}
