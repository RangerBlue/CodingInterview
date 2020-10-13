package util.stackandqueues;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackWithMinimum extends Stack<Integer> {
    ArrayDeque<Integer> stackForMin;

    public StackWithMinimum() {
        this.stackForMin = new ArrayDeque<>();
    }

    public void push(int value) {
        if (value <= min()) {
            stackForMin.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            stackForMin.pop();
        }
        return value;
    }

    public int min() {
        if (stackForMin.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stackForMin.peek();
        }
    }
}
