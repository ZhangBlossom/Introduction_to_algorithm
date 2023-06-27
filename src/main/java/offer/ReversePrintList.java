package offer;

import leetcode.list.ListNode;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/6/20 17:24
 * ReversePrintList类
 */
public class ReversePrintList {
    static int index  =0;
    public static int[] reversePrint(ListNode head){
        if (head==null){
            return new int[0];
        }
        int[] arr = new int[10000];
        recall(head,arr);
        return Arrays.copyOfRange(arr,0,index);
    }
    public static void recall(ListNode head,int[]arr){
        if (head==null){
            return ;
        }
        recall(head.next,arr);
        arr[index++]=head.val;
    }

    //ArrayList<Integer> tmp = new ArrayList<Integer>();
    //public int[] reversePrint(ListNode head) {
    //    recur(head);
    //    int[] res = new int[tmp.size()];
    //    for(int i = 0; i < res.length; i++)
    //        res[i] = tmp.get(i);
    //    return res;
    //}
    //void recur(ListNode head) {
    //    if(head == null) return;
    //    recur(head.next);
    //    tmp.add(head.val);
    //}



    public static void main(String[] args) {
        reversePrint(new ListNode(1,null));
    }
}
