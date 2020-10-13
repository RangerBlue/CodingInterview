package util.stackandqueues;

import java.util.ArrayDeque;

public class MyQueue<T> {
    ArrayDeque<T> stackNewest, stackOldest;

    public MyQueue() {
        this.stackNewest = new ArrayDeque<T>();
        this.stackOldest = new ArrayDeque<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.add(value);
    }

    public void moveElementsInStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        moveElementsInStacks();
        return stackOldest.peek();
    }

    public T remove() {
        moveElementsInStacks();
        return stackOldest.pop();
    }

}
