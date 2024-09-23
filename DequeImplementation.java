package queue;

class DequeNode<T> {
    T data;
    DequeNode<T> next;
    DequeNode<T> prev;

    public DequeNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Deque<T> {
    private DequeNode<T> front;
    private DequeNode<T> rear;

    public Deque() {
        front = null;
        rear = null;
    }

    public void addFront(T item) {
        DequeNode<T> newNode = new DequeNode<>(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public void addRear(T item) {
        DequeNode<T> newNode = new DequeNode<>(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        return data;
    }

    public T removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        return data;
    }

    public T getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return front.data;
    }

    public T getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return rear.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        DequeNode<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class DequeImplementation {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.addRear(10);
        deque.addRear(20);
        deque.addFront(5);
        deque.addFront(1);

        System.out.println("Deque after additions:");
        deque.display();

        System.out.println("Removed from front: " + deque.removeFront());
        System.out.println("Removed from rear: " + deque.removeRear());

        System.out.println("Current front: " + deque.getFront());
        System.out.println("Current rear: " + deque.getRear());

        System.out.println("Final Deque:");
        deque.display();
    }
}

