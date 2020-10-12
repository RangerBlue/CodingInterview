package DataStructures;

import java.util.ArrayDeque;

public class StacksAndQueues {
    //3.6
    public static ArrayDeque<Integer> sortStack(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> tempStack = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > tmp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }
        return tempStack;
    }
}
