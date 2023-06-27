package leetcode.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/14 22:15
 * BinaryWatch类
 */
public class BinaryWatch {
    public  List<String>  binaryWatch(int n){
        List<String> result = new ArrayList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if (Integer.bitCount(i) + Integer.bitCount(j) == n){
                    result.add(i+":"+(j<10?"0":"")+j);
                }
            }
        }
        return result;
    }
}
