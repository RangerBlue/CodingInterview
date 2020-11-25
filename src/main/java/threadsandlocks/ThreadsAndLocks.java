package threadsandlocks;

import util.threads.Chopstick;
import util.threads.Philosopher;

public class ThreadsAndLocks {
    //16.3
    public static int philosophersNumber = 7;

    public static int leftOf(int i) {
        return i;
    }

    public static int rightOf(int i) {
        return (i + 1) % philosophersNumber;
    }

    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[philosophersNumber + 1];
        for (int i = 0; i < philosophersNumber + 1; i++) {
            chopsticks[i] = new Chopstick();
        }

        Philosopher[] philosophers = new Philosopher[philosophersNumber];
        for (int i = 0; i < philosophersNumber; i++) {
            Chopstick left = chopsticks[leftOf(i)];
            Chopstick right = chopsticks[rightOf(i)];
            philosophers[i] = new Philosopher(i, left, right);
        }

        for (int i = 0; i < philosophersNumber; i++) {
            philosophers[i].start();
        }
    }
}
