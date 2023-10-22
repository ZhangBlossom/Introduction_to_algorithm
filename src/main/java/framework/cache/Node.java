package framework.cache;

public class Node<V>{
    public Node pre;
    public Node next;
    public String key;
    public V value;

    public Node(String key, V value) {
        this.key = key;
        this.value = value;
    }

}

