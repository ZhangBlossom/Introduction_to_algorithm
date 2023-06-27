package leetcode.easy.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/27 8:40
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class YanghuiTriangle {
    //region 自己写的 考虑到奇偶数
    //奇数层一半需要再次计算
    //而偶数层直接是对称的
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>(numRows);
//        for (int i = 1; i <= numRows; i++) {
//            Integer[] floor = new Integer[i]; //当前层数据存放
//            floor[0] = 1;
//            floor[i - 1] = 1;
//            if (i >= 3 && i%2==0) {
//                //偶数情况
//                List<Integer> preFloor = list.get(i - 2);
//                    int h = i-2;
//                for (int j = 1; j <i/2; j++) {
//                    int temp = preFloor.get(j-1)+preFloor.get(j);
//                    floor[j] = temp;
//                    floor[h--] = temp;
//                }
//            }else if(i>=3){
//                //奇数
//                List<Integer> preFloor = list.get(i - 2);
//                floor[i/2]=preFloor.get(i/2-1)+preFloor.get(i/2);
//                int h=i-2;
//                for (int j = 1; j <i/2; j++) {
//                    int temp = preFloor.get(j-1)+preFloor.get(j);
//                    floor[j] = temp;
//                    floor[h--] = temp;
//                }
//            }
//            list.add(Arrays.asList(floor));
//        }
//        return list;
//    }
//endregion

    //region 错位相加
    //观察一下规律，发现当前一行只比上一行多了一个元素，最最关键的一点：本行元素等于上一行元素往后错一位再逐个相加：
    //因此我们只要对最后一行单独处理：最后一行首、尾分别添加一个零
// 然后对应位置求和就可以得到新的一行，思路上比较清晰，占用的时间、空间复杂度也都还挺好
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) {
            return res;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(new ArrayList(firstRow));
        int size = res.size();
        while(size < numRows){
            LinkedList<Integer> first = new LinkedList<>();
            first.addFirst(0);
            LinkedList<Integer> second = new LinkedList<>();
            second.addLast(0);
            for(int x: res.get(size-1)){
                first.addFirst(x);
                second.addLast(x);
            }
            List<Integer> newRow = new ArrayList<>();
            for(int i=0; i<first.size(); i++){
                newRow.add(first.get(i) + second.get(i));
            }
            res.add(newRow);
            size++;
        }
        return res;
    }

    //endregion
    public static void main(String[] args) {

    }
}
