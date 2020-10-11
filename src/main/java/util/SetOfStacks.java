package util;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SetOfStacks {
    ArrayList<ArrayDeque<Integer>> stacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public ArrayDeque<Integer> getLastStack(){
       return stacks.size() == 0 ? null : stacks.get(stacks.size()-1);
    }

    public boolean isStackFull(ArrayDeque<Integer> stack){
        return stack.size() == capacity;
    }

    public void push(int e){
        ArrayDeque<Integer> last = getLastStack();
        if(last != null && !isStackFull(last)){
            last.push(e);
        }else {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(e);
            stacks.add(stack);
        }
    }

    public int pop(){
        ArrayDeque<Integer> last = getLastStack();
        int element = last.pop();
        if(last.size()==0){
            stacks.remove(last);
        }
        return element;
    }
}
