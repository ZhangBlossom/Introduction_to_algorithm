package offer.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/7/10 20:08
 * PhoneNumberCombination类
 */
public class PhoneNumberCombination {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
    public void backtrack1(List<String> combinations, Map<Character, String> phoneMap,
                          String digits, int i, StringBuffer stringBuffer) {
        if (i == digits.length()){
            combinations.add(stringBuffer.toString());
            return ;
        }else{
            char c = digits.charAt(i);
            String value = phoneMap.get(c);
            int len = value.length();
            for(int j = 0;j<len;j++){
                stringBuffer.append(value.charAt(j));
                backtrack(combinations,phoneMap,digits,i+1,stringBuffer);
                stringBuffer.deleteCharAt(j);
            }
        }
    }
}
