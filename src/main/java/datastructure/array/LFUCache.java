package datastructure.array;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCachePlus {

    private int capacity; // 容量限制
    private int size;     // 当前数据个数
    private int minFreq;  // 当前最小频率

    private Map<Integer, Node> cache; // key和数据的映射
    private Map<Integer, LinkedHashSet<Node>> freqMap; // 数据频率和对应数据组成的链表

    public LFUCachePlus(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 1;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {

        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
	    // 增加数据的访问频率
        freqPlus(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (capacity <= 0) {
            return;
        }

        Node node = cache.get(key);
        if (node != null) {
            // 如果存在则增加该数据的访问频次
            node.value = value;
            freqPlus(node);
        } else {
            // 淘汰数据
            eliminate();
            // 新增数据并放到数据频率为1的数据链表中
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            LinkedHashSet<Node> set = freqMap.get(1);
            //初始化频率链表
            if (set == null) {
                set = new LinkedHashSet<>();
                freqMap.put(1, set);
            }

            set.add(newNode);
            minFreq = 1;
            size++;
        }

    }

    private void eliminate() {

        if (size < capacity) {
            return;
        }

        LinkedHashSet<Node> set = freqMap.get(minFreq);
        //使用的是LinkedHashSet，有序，因此直接删除头节点
        //头节点就是最老的数据
        Node node = set.iterator().next();
        set.remove(node);
        cache.remove(node.key);

        size--;
    }

    private void freqPlus(Node node) {

        int frequency = node.frequency;
        LinkedHashSet<Node> oldSet = freqMap.get(frequency);
        //移除当前这个被获取到的节点
        oldSet.remove(node);

        // 更新最小数据频率
        if (minFreq == frequency && oldSet.isEmpty()) {
            minFreq++;
        }

        frequency++;
        node.frequency++;
        LinkedHashSet<Node> set = freqMap.get(frequency);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(frequency, set);
        }
        set.add(node);
    }
}

class Node {
    int key;
    int value;
    int frequency = 1;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        LFUCachePlus cache = new LFUCachePlus(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        //空间不足 剔除1 放入3
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        //空间不足 此时有3 2 ，访问次数都为1，但是3的访问时间更久之前，剔除3
        cache.put(4, 4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));
    }
}
