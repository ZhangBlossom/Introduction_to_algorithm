package leetcode.string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/5/17 10:24
 * FizzBuzz类
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            //StringBuffer sb = new StringBuffer();
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("Fizz Buzz");
            } else if (i % 3 == 0) {
                //sb.append("Fizz");
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                //sb.append("Buzz");
                answer.add("Buzz");
            } else {
                answer.add(i+"");
            }
        }
        return answer;
    }

    //由于要出现Fizz Buzz需要满足Fizz和Buzz的条件
    //所以可以用字符串拼接之后在放入到list中
    public List<String> fizzBuzzWithSB(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}
