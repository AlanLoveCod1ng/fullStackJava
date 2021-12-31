public class ThreadDemo {

    public static void main(String[] args) {
        // write your code here
        //version 1: extends Thread class
//        Counter c1 = new Counter(1);
//        Counter c2 = new Counter(2);
//        c1.start();
//        c2.start();
//        System.out.println("*************************");

        //version 2: implements Runnable interface
//        Thread t1 = new Thread(new MyCounter(1));
//        Thread t2 = new Thread(new MyCounter(2));
//        t1.start();
//        t2.start();

        //version 3: anonymous class
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 9; i++) {
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("The number is " + i + " from thread " + 1);
//                }
//            }
//        });
//        t1.start();

        //version 4: lambda expression
        new Thread(()->{
            for (int i = 0; i <= 9; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The number is " + i + " from thread " + 1);
            }
        }).start();

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
class MyCounter implements Runnable{
    int index;

    MyCounter(int index) {
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
