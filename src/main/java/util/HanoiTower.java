package util;

import java.util.ArrayDeque;

public class HanoiTower {
    public ArrayDeque<Integer> disks;
    private int index;

    public HanoiTower(int index) {
        this.disks = new ArrayDeque<>();
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void add(int level) {
        if (!disks.isEmpty() && disks.peek() <= level) {
            System.out.println("ERROR");
        } else {
            disks.push(level);
        }
    }

    public void moveTopTo(HanoiTower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}
