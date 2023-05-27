package com.base.learn.cache;

import java.util.HashMap;

/**
 * @author: 张锦标
 * @date: 2023/5/26 12:32
 * LRUCache类
 */
public class LRUCache<V> {
    private HashMap<String,Node<V>> map = new HashMap<>();
    private Integer limit ;
    private Node<V> head;
    private Node<V> end;

    public LRUCache(Integer limit) {
        this.limit = limit;
    }

    public V get(String key){
        //1:从map中获取，如果没有获取到，那么返回null
        Node<V> node = map.get(key);
        if (node==null){
            return null;
        }
        //2:获取到了,需要将当前节点移动到链表尾部
        removeNodeToTail(node);
        return node.value;
    }

    private void removeNodeToTail(Node<V> node) {
        //如果已经是队尾的节点无需移动
        if (node == end) {
            return;
        }
        //先从原位置删掉
        removeNode(node);
        //放到链尾
        addNodeToTail(node);
    }

    /**
     * 将当前节点放入到链表尾部
     * @param node 要放入到链表尾部的节点
     */
    private void addNodeToTail(Node<V> node) {
        //当前链表不为空判断
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        //当前节点设定为尾节点
        end = node;
        //如果当前头节点为空 同时设定为头节点
        if (head == null) {
            head = node;
        }
    }

    /**
     * 删除链表中的节点
     * @param node 要删除的节点
     * @return 返回被删除的节点对应的key
     */
    private String removeNode(Node<V> node) {
        if (node == head && node == end) {
            //移除唯一的节点
            head = null;
            end = null;
            //这个if判断是为了使得removeNode方法更加通用
            //在被removeNodeToTail这个方法调用的时候是不会走这个判断的
        } else if (node == end) {
            //移除尾节点
            end = end.pre;
            end.next = null;
        }
        else if (node == head) {
            //移除头节点
            head = head.next;
            head.pre = null;
        } else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public void put(String key,V value){
        Node<V> node = map.get(key);
        if (node != null) {
            //节点已存在更新里面的值
            node.value = value;
            //移动到链尾
            removeNodeToTail(node);
        } else {
            //不存在，首先判断容量，容量满的情况下先删除不常用的，然后插入新节点，容量不满的情况下直接插入
            if (map.size() >= limit) {
                System.out.println("缓存空间不足,淘汰数据...");
                //从链表中移除最不常用的
                String oldKey = removeNode(head);
                System.out.println("被淘汰的数据为:"+oldKey);
                //从hashmap中移除
                map.remove(oldKey);
            }
            node = new Node(key, value);
            //添加到链尾
            addNodeToTail(node);
            //添加到hashmap
            map.put(key, node);
        }
    }


    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache(2);
        //此时缓存数据为1 2
        cache.put("1", "1");
        cache.put("2", "2");
        //此时数据1为尾节点
        System.out.println(cache.get("1"));
        //空间不足 淘汰头节点2
        //此时数据为 1 3
        cache.put("3", "3");
        //此时没有数据2 返回null
        System.out.println(cache.get("2"));
        //空间不足 淘汰1 放入4
        cache.put("4", "4");
        //没有1 返回null
        System.out.println(cache.get("1"));
        System.out.println(cache.get("3"));
        System.out.println(cache.get("4"));
    }
}
