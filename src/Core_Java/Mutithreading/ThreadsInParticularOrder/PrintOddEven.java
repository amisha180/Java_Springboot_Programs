package Core_Java.Mutithreading.ThreadsInParticularOrder;
class NumberPrinter {
    private int number = 1;
    private static final int MAX = 10;

    public void printOdd() {
        synchronized (this) {
            while (number < MAX) {
                while (number % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " - " + number);
                    number++;
                    notify();
                }
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (number <= MAX) {
                while (number % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " - " + number);
                    number++;
                    notify();
                }
            }
        }
    }
}

public class PrintOddEven {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                numberPrinter.printOdd();
            }
        }, "OddThread");

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                numberPrinter.printEven();
            }
        }, "EvenThread");

        oddThread.start();
        evenThread.start();
    }
}


