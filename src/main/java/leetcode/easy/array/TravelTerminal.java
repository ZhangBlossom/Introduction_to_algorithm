package leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/6 9:12
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 1436旅行终点站
 */
public class TravelTerminal {
    public String destCity(List<List<String>> paths) {
        Map<String,String>map = new HashMap<>(paths.size());
        List<String> end = new ArrayList<>(paths.size());
        for (List<String> path : paths) {
            map.put(path.get(0),path.get(1));
            end.add(path.get(1));
        }
        for (String s : end) {
            if(!map.containsKey(s))
                return s;
        }
        return paths.get(0).get(1);
        //LeetCode 给的答案
        // Set<String> citiesA = new HashSet<String>();
        // for (List<String> path : paths) {
        //     citiesA.add(path.get(0));
        // }
        // for (List<String> path : paths) {
        //     if (!citiesA.contains(path.get(1))) {
        //         return path.get(1);
        //     }
        // }
        // return "";
    }

    public static void main(String[] args) {

    }
}
