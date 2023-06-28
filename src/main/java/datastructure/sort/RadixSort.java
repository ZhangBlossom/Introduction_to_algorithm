package datastructure.sort;

import java.util.Arrays;

/**
 * @author: Serendipity
 * Date: 2022/2/1 21:02
 * Description:
 * ����������Ч�ʸߵ��ȶ�������
 * ����������Ͱ��������� ��ʵ��˼·����:
 * ��������ÿ��λ�����ܳ��ֵ����ֵ�ʮ����ά����Ͱ0-9
 * ����ЩͰ���ɴ�����ֵ�����
 * ��һ�ν�ȡ�����ֵĸ�λ,�ڶ���ʮλ,�Դ�����,ÿ�λ�ȡ����
 * ֱ�Ӹ���Ͱ��ԭ�����ݶ�����ֱ�Ӳ���Ͱ������(û�б�Ҫ)
 */
public class RadixSort {
    public static void radixSort(int[]arr){
        //1:�õ�������������ݵ�λ��
        int max=arr[0];//�������
        int maxLength=0;//������ݳ���
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        maxLength=(max+"").length();
        //2:����Ͱ�ʹ�����¼Ͱ�����ݵ�����
        int[][]bucket=new int[10][arr.length];//������ݵ�Ͱ
        int[]bucketCount=new int[arr.length];//��¼ÿ��Ͱ�����ݵ�Ͱ
        int digitOfElement=0;//��ǰλ����Ӧ��ֵ0-9
        for(int i=0,n=1;i<maxLength;n*=10,i++){//��Ҫ ����������ֵĳ���
            for(int j=0;j<arr.length;j++){//��ÿһ�����ݽ��б���
                digitOfElement=arr[j]/n%10;//ȡ��������ݵ�ǰ�ĸ�λ/ʮλ/��λ��ֵ
                bucket[digitOfElement][bucketCount[digitOfElement]]=arr[j];//����ǰ���ݷ����ӦͰ��
                bucketCount[digitOfElement]++;//��Ӧ��Ͱ�е�����������
            }
            int index=0;//���ڶ�ԭ������и���
            for(int k=0;k<bucketCount.length;k++){//��ʮ��Ͱ���б���
                if(bucketCount[k]!=0){//�жϵ�ǰͰ���Ƿ������� ��ǰ����ֵ����һ�ִ�Ž�ȥ�Ĵ���������ԭ��û�б����ǵ����ݸ���
                    for(int l=0;l<bucketCount[k];l++){//������������ֱ�Ӹ��ǵ�ԭ����
                        arr[index++]=bucket[k][l];
                    }
                }
                bucketCount[k]=0;//��ֱ�Ӳ���Ͱ�����ݶ��Ǹ��� ��Ϊû�б�Ҫ
            }//��Ϊÿ�δӼ���Ͱ��ȡ�õ����ݸ���ͨ��bucketCount����õ� ��ÿ��ȡ��������ݺ�
        }//���ὫbucketCount��Ϊ0
        System.out.println("�����:"+ Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5412, 12, 3, 513, 0, 6, 324};
        radixSort(arr);
    }
}
