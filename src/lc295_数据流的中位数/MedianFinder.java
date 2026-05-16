package lc295_数据流的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {
        if (!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() - minHeap.size() < 0) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        double min = minHeap.isEmpty() ? 0 : minHeap.peek();
        double max = maxHeap.isEmpty() ? 0 : maxHeap.peek();

        return minHeap.size() == maxHeap.size() ? (min + max) / 2.0 : (double) maxHeap.peek();
    }
}
