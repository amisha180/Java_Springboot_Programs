package Core_Java.Mutithreading.Problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bathroom {
    private final Lock lock = new ReentrantLock();
    private final Condition emptyBathroom = lock.newCondition();
    private String currentGender = null;
    private int count = 0;

    public void enterBathroom(String gender) throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            while (currentGender != null && !currentGender.equals(gender)) {
                emptyBathroom.await();
            }
            currentGender = gender;
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void leaveBathroom() {
        lock.lock();
        try {
            count--;
            if (count == 0) {
                currentGender = null;
                emptyBathroom.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}

class Person implements Runnable {
    private final Bathroom bathroom;
    private final String gender;

    public Person(Bathroom bathroom, String gender) {
        this.bathroom = bathroom;
        this.gender = gender;
    }

    @Override
    public void run() {
        try {
            bathroom.enterBathroom(gender);
            System.out.println(gender + " entered the bathroom");
            // Simulate using the bathroom
            Thread.sleep(1000);
            bathroom.leaveBathroom();
            System.out.println(gender + " left the bathroom");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class UnisexBathroomProblem {
    public static void main(String[] args) {
        Bathroom bathroom = new Bathroom();

        Thread t1 = new Thread(new Person(bathroom, "Male"));
        Thread t2 = new Thread(new Person(bathroom, "Female"));
        Thread t3 = new Thread(new Person(bathroom, "Female"));
        Thread t4 = new Thread(new Person(bathroom, "Female"));
        Thread t5 = new Thread(new Person(bathroom, "Female"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

