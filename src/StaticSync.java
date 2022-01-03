public class StaticSync {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Brackets.print(1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Brackets.print(2);
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1);
    }
}

class Brackets {
    static synchronized void print(int index) {
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
        System.out.println(index);
    }
}