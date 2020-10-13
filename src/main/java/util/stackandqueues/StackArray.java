package util.stackandqueues;

public class StackArray {
    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1};

    public void push(int stackNum, int element) throws Exception {
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new Exception("There is no space for new element");
        }
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = element;

    }

    public int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }

    public int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception("Stack is empty");
        }

        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

}
