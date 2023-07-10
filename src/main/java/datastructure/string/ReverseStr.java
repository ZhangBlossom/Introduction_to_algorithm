package datastructure.string;

/**
 * @author: 张锦标
 * @date: 2023/5/25 13:15
 * ReverseStr类
 */
public class ReverseStr {
    /**
     * 用于反转字符数组中index1~index2位置的这一段
     * 左闭右开区间,index1<=下标<index2
     */
    public static void reverse(char[] chr,int index1,int index2){
        if(index2-index1 < 2) {
            return;
        }
        int j=index2-1;//右侧下标
        for(int i=index1;i<(index2+index1)/2;i++){
            swap(chr,i,j--);
       }
    }

    /**
     * 旋转
     * 使用三次反转，实现旋转
     * 数组注意区间取值
     * @param m 从位置m处进行旋转
     */
    public static void rotation(char[] chr,int m){
        //第一次倒置0~m位置
        reverse(chr,0,m);
        //第二次倒置m~最后位置
        reverse(chr,m,chr.length);
        //最后整体倒置
        reverse(chr,0,chr.length);
    }

    private static void swap(char[] arr,int index1,int index2){
        char temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    public static void main(String[] args) {
        String s = "123456";
        char[] chars = s.toCharArray();
        rotation(chars,2);
        System.out.println(chars);
    }
}
