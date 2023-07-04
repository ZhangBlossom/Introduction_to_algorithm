package offer.greed;

/**
 * @author: 张锦标
 * @date: 2023/6/28 9:03
 * PlantFlower类
 */
public class PlantFlower {
    public boolean canPlaceFlowers(int[] flowerbed,int n){
        for(int i=0,len=flowerbed.length;i<len && n>0;){
            if (flowerbed[i]==1){
                i+=2;
            }else if(i==len-1 || flowerbed[i+1]==0){
                n--;
                i+=2;
            }else {//当前位置是空 但是下一个位置是花 那么要跳3步
                i+=3;
            }
        }
        return n<=0;
    }
}
