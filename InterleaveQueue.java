package queue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {

    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            System.out.println("Queue size must be even.");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int halfSize = queue.size() / 2;

        // Push the first half of the queue into the stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the elements from the stack back to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Move the first half of the queue to the back
        for (int i = 0; i < halfSize; i++) {
            queue.offer(queue.poll());
        }

        // Push the first half of the queue into the stack again
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Interleave the elements of the stack and the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
            queue.offer(queue.poll());
        }
    }

    public static void printQueue(Queue<Integer> queue) {
        for (Integer num : queue) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Sample queue: 1 2 3 4 5 6 7 8
        for (int i = 1; i <= 8; i++) {
            queue.offer(i);
        }

        System.out.println("Original Queue:");
        printQueue(queue);

        interleaveQueue(queue);

        System.out.println("Interleaved Queue:");
        printQueue(queue);
    }
}
