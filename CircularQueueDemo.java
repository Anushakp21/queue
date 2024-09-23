package queue;

class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.size = 0;
        this.rear = capacity - 1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        System.out.println("Enqueued " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued " + value);
        return value;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[rear];
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);

        System.out.println("Front element: " + circularQueue.front());
        System.out.println("Rear element: " + circularQueue.rear());

        circularQueue.dequeue();
        circularQueue.enqueue(60);

        System.out.println("Front element after dequeue: " + circularQueue.front());
        System.out.println("Rear element after enqueue: " + circularQueue.rear());

        while (!circularQueue.isEmpty()) {
            circularQueue.dequeue();
        }

        circularQueue.dequeue();  // Attempting to dequeue from an empty queue
    }
}

