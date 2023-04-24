package main.java.com.bluebridge.learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/13 9:58
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 1 单词分析
 */
public class WordAnalysis {
    //    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String line = scan.nextLine();
//        Map<String,Integer> map = new HashMap<>();
//        for(int i=0;i< line.length();i++){
//            String c = line.charAt(i)+"";
//            if(map.containsKey(c)){
//                map.put(c,map.get(c)+1);
//            }else{
//                map.put(c,1);
//            }
//        }
//        String word = "";
//        int count = 0;
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
////            System.out.println(entry.getKey());
////            System.out.println(entry.getValue());
//            if (count<entry.getValue()){
//                word=entry.getKey();
//                count=entry.getValue();
//            }
//        }
//        System.out.println(word);
//        System.out.println(count);
//
//        //在此输入您的代码...
//        scan.close();
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[]word = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            word[c-'a']++;
        }
        int max = 0;
        int index = 0;
        for (int i=0;i<word.length;i++){
            if (word[i]>max){
                max=word[i];
                index=i;
            }
        }
        System.out.println((char)('a'+index));
        System.out.println(max);
    }
}
