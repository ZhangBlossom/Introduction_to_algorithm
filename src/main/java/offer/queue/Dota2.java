package offer.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 张锦标
 * @date: 2023/7/13 9:12
 * Dota2类
 */
public class Dota2 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        int n = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i)=='R'){
                radiant.add(i);
            }else{
                dire.add(i);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r =radiant.poll();
            int d = dire.poll();
            if (r<d){
                radiant.offer(r+n);
            }else{
                dire.offer(d+n);
            }
        }
        return radiant.isEmpty()?"Dire":"Radiant";
    }
}
