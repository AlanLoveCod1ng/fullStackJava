public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {
        bracket b1 = new bracket();
        Thread t1 = new Thread(() -> {
            long time = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                b1.print();
            }
            time = System.currentTimeMillis() - time;
            System.out.println(time);
        });
        Thread t2 = new Thread(() -> {
            long time = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                b1.print();
            }
            time = System.currentTimeMillis() - time;
            System.out.println(time);
        });
        t1.start();
        t2.start();
        Thread.sleep(1);
    }
}

class bracket {
    private final Object lock  = "lock";
    void print() {
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i < 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(25);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}