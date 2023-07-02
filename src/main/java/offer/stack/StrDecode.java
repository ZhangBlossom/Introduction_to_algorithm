package offer.stack;

import javafx.beans.binding.StringBinding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/7/2 11:09
 * StrDecode类
 */
public class StrDecode {
    static int ptr;

    public static String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else { //遇到']'了
                ++ptr; //跳过']'即可
                LinkedList<String> sub = new LinkedList<String>();
                //把括号内的内容拷贝到sub
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                //反转sub使得其顺序正确
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }
    //得到完整数字
    public static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }
    //得到完整字符串
    public static String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        decodeString("3[a2[c]]");
    }
}
