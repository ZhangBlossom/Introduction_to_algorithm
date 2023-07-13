package offer.heap;

import java.util.PriorityQueue;

class SmallestInfiniteSet {
    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            queue.offer(i);
        }
    }

    public int popSmallest() {
        return queue.poll();
    }

    public void addBack(int num) {
        if (!queue.contains(num)) {
            queue.offer(num);
        }
    }
}