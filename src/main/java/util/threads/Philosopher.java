package util.threads;

import java.util.Random;

public class Philosopher extends Thread {
    private final int maxPause = 100;
    private int bites = 10;

    private Chopstick left;
    private Chopstick right;
    private int index;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        this.left = left;
        this.right = right;
    }

    public void eat() {
        System.out.println("Philosopher " + index + ": is starting eating");
        if (pickUp()) {
            chew();
            putDown();
            System.out.println("Philosopher " + index + ": has finished eating");
        } else {
            System.out.println("Philosopher " + index + ": decided not to eat");
        }
    }

    public boolean pickUp() {
        pause();
        if (!left.pickUp()) {
            return false;
        }
        pause();
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        pause();
        return true;
    }

    public void chew() {
        System.out.println("Philosopher " + index + ": is eating");
        pause();
    }

    public void pause() {
        try {
            Random r = new Random();
            int pause = r.nextInt((maxPause) + 1);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}
