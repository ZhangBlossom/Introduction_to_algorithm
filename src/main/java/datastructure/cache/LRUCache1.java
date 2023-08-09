package datastructure.cache;

import java.util.HashMap;

/**
 * @author: 张锦标
 * @date: 2023/7/21 15:20
 * LRUCache1类
 */
public class LRUCache1<V> {
    private HashMap<String, Node<V>> map = new HashMap<>();
    private Node<V> head;
    private Node<V> end;
    private Integer limit;

    public LRUCache1(int i) {
        this.limit = i;
    }

    public V get(String key) {
        Node<V> node = map.get(key);
        if (node == null) {
            return null;
        }
        removeNodeToTail(node);
        return node.value;
    }

    private void removeNodeToTail(Node<V> node) {
        if (node == end) {
            return;
        }
        removeNode(node);
        addNodeToTail(node);
    }

    private void addNodeToTail(Node<V> node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }

    }

    private String removeNode(Node<V> node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        }  else if (node == head) {
            head = head.next;
            head.pre = null;
        }else if (node == end) {
            end = end.pre;
            end.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public void put(String key, V value) {
        Node<V> node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNodeToTail(node);
        } else {
            if (map.size() >= limit) {
                String oldKey = removeNode(head);
                map.remove(oldKey);
            }
            node = new Node<>(key, value);
            addNodeToTail(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache1<String> cache = new LRUCache1(2);
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
