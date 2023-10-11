package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/10/11 19:47
 * _341NestedIterator类
 */
public class _341NestedIterator {
    private List<Integer> list = new ArrayList<>();
    private int index;
    private int size;
    public _341NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        this.index=0;
        this.size=list.size();
    }

    public Integer next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return this.index<this.size;
    }
    public void dfs(List<NestedInteger> nestedList){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                list.add(ni.getInteger());
            }else{
                dfs(ni.getList());
            }
        }
    }

    private class NestedInteger {
        private Integer integer;

        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public List<NestedInteger> getList() {
            return null;
        }
    }
}
