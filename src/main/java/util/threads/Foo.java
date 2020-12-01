package util.threads;

import java.util.concurrent.Semaphore;

public class Foo {
    public int pauseTime = 1000;
    public Semaphore sem1;
    public Semaphore sem2;

    public Foo() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);

            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        try {
            System.out.println("Starting thread 1.");
            Thread.sleep(pauseTime);
            System.out.println("Finishing 1.");
            sem1.release();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void second() {
        try {
            sem1.acquire();
            sem1.release();
            System.out.println("Starting thread 2.");
            Thread.sleep(pauseTime);
            System.out.println("Finishing 2.");
            sem2.release();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void third() {
        try {
            sem2.acquire();
            sem2.release();
            System.out.println("Starting thread 3.");
            Thread.sleep(pauseTime);
            System.out.println("Finishing 3.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
