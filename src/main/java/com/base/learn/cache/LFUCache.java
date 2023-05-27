package com.base.learn.cache;

import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;
import java.util.Map.Entry;

public class LFUCache<V> {

    private Map<String, Node<V>> cache = null;
    private Map<Long, LinkedHashSet<Node<V>>> freqMap = null;
    private int capacity = 0;
    private int size = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.freqMap = new HashMap<>();
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public V get(String key){
        Node<V> node = cache.get(key);
        if (node==null){
            return null;
        }
        node.count++;
        node.lastGetTime=System.nanoTime();
        cache.put(key,node);
        LinkedHashSet<Node<V>> set = freqMap.get(node.count);
        if (set==null){
            set = new LinkedHashSet<>();
        }
        set.add(node);
        freqMap.put(node.count,set);
        return node.value;
    }


    public void put(String key, V value) {
        size++;
        //更新操作
        if (cache.get(key) != null) {
            cache.remove(key);
            size--;
        }
        Node<V> node = new Node<V>();
        node.value = value;
        //由于是更新操作 把使用次数设定为1
        node.count = 1;
        node.lastGetTime = System.nanoTime();
        //判断是否还有空间存放
        if (size <= this.capacity) {
            cache.put(key, node);
        } else {
            //没有空间则移除那个访问频次最少的数据
            removeLastNode();
            if (cache.size() < this.capacity) {
                cache.put(key, node);
            }
        }

    }

    // 淘汰最少使用的缓存
    private void removeLastNode() {
        long minCount = 0; //最小的计数数
        long oldestGetTime = 0; //最老的获取时间
        String waitRemoveKey = null; //等待要删除的key
        long flag = 0; //表示当前遍历的数据的个数
        //首先获取到cache缓存中的所有节点
        //然后去记录了频次的链表中再去查找频次最低，访问时间最早的数据
        //然后删除这个数据
        Set<Entry<String, Node<V>>> cacheSet = this.cache.entrySet();
        LinkedHashSet<Entry<String, Node<V>>> linkedHashSet = new LinkedHashSet<>(cacheSet);
        Iterator<Entry<String, Node<V>>> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            Entry<String, Node<V>> entry = iterator.next();
            flag++;
            String key = entry.getKey();
            long count = entry.getValue().count;
            long lastGetTime = entry.getValue().lastGetTime;
            //判断当前记录是否是第一条记录
            if (flag == 1) {
                minCount = count;
                waitRemoveKey = key;
                oldestGetTime = entry.getValue().lastGetTime;
                if (minCount == 1) { //是第一条记录并且访问次数为最少的1
                    break; //直接退出循环并且删除该数据
                }
            }
            //判断当前数据是否count数更小
            if (count < minCount) {
                minCount = count;
                waitRemoveKey = key;
                oldestGetTime = lastGetTime;
            }
            if (minCount == count) {//两条记录他们的访问次数一样
                //访问次数一样并且数据的访问时间更老
                if (oldestGetTime > lastGetTime) {
                    minCount = count;
                    waitRemoveKey = key;
                    oldestGetTime = lastGetTime;
                }
            }
        }
        //删除数据
        if (waitRemoveKey != null) {
            this.cache.remove(waitRemoveKey);
        }

    }

    class Node<V> {

        public V value;
        public long count;
        public long lastGetTime;

    }

    public static void main(String[] args) {
        LFUCache<Integer> cache = new LFUCache(2);
        cache.put("1", 1);
        cache.put("2", 2);
        cache.put("3", 3);
        //空间不足 剔除1 放入3
        System.out.println(cache.get("3"));
        System.out.println(cache.get("2"));
        //空间不足 此时有3 2 ，访问次数都为1，但是3的访问时间更久之前，剔除3
        cache.put("4", 4);
        System.out.println(cache.get("3"));
        System.out.println(cache.get("4"));
        System.out.println(cache.get("2"));
    }

}
