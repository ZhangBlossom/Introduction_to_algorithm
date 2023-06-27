package datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author: 张锦标
 * @date: 2023/4/26 15:48
 * DynamicArray类
 */
public class DynamicArray implements Iterable<Integer> {
    private int capacity = 10; //当前容量
    private int size = 0; //当前数据量
    private int[] array = {}; //数组
    private double threadsold = 0.75;

    /**
     * 添加数据到末尾
     *
     * @param value 数据
     * @return 返回索引
     */
    public void addLast(int value) {
        add(size, value);
    }

    /**
     * 向数组的index位置插入一个值
     *
     * @param index 插入位置
     * @param value 数据
     */
    public void add(int index, int value) {
        if (index < 0) {
            throw new RuntimeException("不要传入小于0的index");
        }
        checkAndGrow();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = value;
        size++;
    }

    public int remove(int index) {
        if (index < 0) {
            throw new RuntimeException("不要传入小于0的index");
        }
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    /**
     * 获取某个索引位置的值
     *
     * @param index 索引值
     * @return
     */
    public int get(int index) {
        if (index < 0) {
            throw new RuntimeException("不要传入小于0的index");
        }
        return array[index];
    }

    /**
     * 输入一个消费者对数组内容进行消费
     *
     * @param consumer 消费者
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 扩容方法 每次扩容为原容量的1.5倍
     */
    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            capacity += capacity >>> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() { //判断是否由下一个元素
                return i < size;
            }

            @Override
            public Integer next() { //获取下一个元素 并且指针下移
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.add(2, 123);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        System.out.println(dynamicArray.remove(3));
        dynamicArray.forEach(x -> {
            System.out.println(x);
        });
        for (Integer i : dynamicArray) {
            System.out.println(i);
        }
        dynamicArray.stream().forEach(System.out::println);
    }
}
