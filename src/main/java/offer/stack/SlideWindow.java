package offer.stack;


import java.util.LinkedList;

/**
 * @author: 张锦标
 * @date: 2023/5/27 21:10
 * SlideWindow类
 */
public class SlideWindow {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            //判断qmax是否为空 不为空 那么判断当前元素是否大于队尾
            //如果大于队尾元素 那么直接移除队头元素
            if (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollFirst();
            }
            //无论如何都会将当前索引插入队尾
            qmax.addLast(arr[i]);
            //当前队头元素索引是否等于i-w 如果是，说明过期
            if (qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            //判断是否开始生成窗口
            if (i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
