package offer.stack;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/7/2 9:51
 * CrashOfPlanet类
 */
public class CrashOfPlanet {
    public int[] asteroidCollision(int[] asteroids) {
        // + >  |  - <
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid<0  && !stack.isEmpty() && stack.peek()>0){
                alive = stack.peek() < -asteroid; //aster是否继续存活
                if (stack.peek()<= -asteroid){
                    stack.pop();
                }

            }
            //当前行星存活 放入栈中
            if (alive){
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
