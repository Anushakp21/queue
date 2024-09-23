package queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.isEmpty() ? -1 : queue1.remove();
    }

    public int top() {
        return queue1.isEmpty() ? -1 : queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());
        System.out.println("Pop element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.top());
        System.out.println("Is Stack Empty? " + stack.isEmpty());

        stack.push(40);
        System.out.println("Top element after push: " + stack.top());
        System.out.println("Pop element: " + stack.pop());
        System.out.println("Is Stack Empty? " + stack.isEmpty());
    }
}

