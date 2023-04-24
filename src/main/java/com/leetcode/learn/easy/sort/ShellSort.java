package main.java.com.leetcode.learn.easy.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/1/31 12:54
 * Description:
 * ϣ������
 * ϣ�������ǲ������������ ��ʹ����һ������
 * ���������Ĵ���,ÿ�εı�������ֱ����Ծʽ�ȶ�
 * ���ܽ��ȽϺ��������ֱ�Ӻܿ��Ū��ǰ��
 * ����д������������޶� ֻ���ڲ�forѭ���жϵ�ʱ����Ҫ����һ��j>0&&arr[0]<arr[j]
 *
 */
public class ShellSort {
    private int arr[];
    public void shellSort(int[]arr){
        int i,j;
        int increment=arr.length;//������ֱ�Ӳ��������޶� ����������һ������������Ծʽ����
        do{
            increment=increment/3+1;//��1��Ϊ�������ʹ������ȡ��1�������һ������
            for(i=increment+1;i<=arr.length-1;i++){
                if(arr[i]<arr[i-increment]){
                    arr[0]=arr[i];//С����������Ϊ�ڱ����
                    for(j=i-increment;j>0&&arr[j]>arr[0];j-=increment){//Ϊ��������ҵ���Ӧ�ò����λ�� ��incrementΪ���Ѱ�Ҳ���λ��
                        arr[j+increment]=arr[j];//�����������ݺ���increment
                    }//�˳�forѭ��ʱ�Ѿ�Ϊ���С���������˿ɲ����λ��
                    arr[j+increment]=arr[0];//��Ҫ��һ��increment����Ϊ����˳�֮ǰ-increment��
                    //����j��ʱλ����ǰƫ����increment
                }
            }
        }while(increment>1);//����ֹͣ��������ִ��increment=1ʱ������ ������򽫻ύ��
        //����Ԫ��,Ҳ���ǽ������һ������
    }
    public static void main(String[] args) {
        ShellSort sh = new ShellSort();
        sh.arr=new int[]{0,8,87,7,6,54,34,123};
        sh.shellSort(sh.arr);
        System.out.println(Arrays.toString(sh.arr));
    }
}
