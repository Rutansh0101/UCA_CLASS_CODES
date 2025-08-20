import java.util.Scanner;

class NumberPrinter extends Thread {
    private final Object lock = new Object();
    private boolean running = false;
    private boolean exit = false;

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (lock) {
                while (!running && !exit) {
                    try {
                        lock.wait(); // wait until notified
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (exit) break; // exit loop
            }

            System.out.print(i + "\n");
            i++;
            try {
                Thread.sleep(500); // slow down printing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nPrinter thread stopped.");
    }

    public void startPrinting() {
        synchronized (lock) {
            running = true;
            lock.notify(); // wake up thread
        }
    }

    public void stopPrinting() {
        synchronized (lock) {
            running = false;
        }
    }

    public void exitThread() {
        synchronized (lock) {
            exit = true;
            lock.notify(); // wake up if waiting
        }
    }
}

public class ThreadController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberPrinter printer = new NumberPrinter();
        printer.start();

        while (true) {
            System.out.print("\nEnter command (start/stop/exit): ");
            String cmd = sc.nextLine().trim().toLowerCase();

            if (cmd.equals("start")) {
                printer.startPrinting();
            } else if (cmd.equals("stop")) {
                printer.stopPrinting();
            } else if (cmd.equals("exit")) {
                printer.exitThread();
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
        System.out.println("Main thread exiting...");
    }
}
