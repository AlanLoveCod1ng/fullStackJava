public class Main {

    public static void main(String[] args) {
        // write your code here
        Counter c1 = new Counter(1);
        Counter c2 = new Counter(2);
        c1.start();
        c2.start();
        System.out.println("*************************");
    }
}

class Counter extends Thread {
    int index;

    Counter(int index) {
        this.index = index;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 9; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The number is " + i + " from thread " + index);
        }
    }
}
