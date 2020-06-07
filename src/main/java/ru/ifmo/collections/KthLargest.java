package ru.ifmo.collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final Queue<Integer> priorityQueue;

    public KthLargest(int k, int[] numbers) {
        this.priorityQueue = new PriorityQueue<>();
        for (var number : numbers) {
            priorityQueue.add(number);
        }
        while (priorityQueue.size() > k) {
            priorityQueue.remove();
        }
    }

    public int add(int val) {
        if (val > priorityQueue.peek()) {
            priorityQueue.add(val);
            priorityQueue.remove();
        }
        return priorityQueue.peek();
    }
}