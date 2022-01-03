import java.util.concurrent.CountDownLatch;
import java.util.zip.CheckedOutputStream;

public class LatchLearn {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        SimpleThread st1 = new SimpleThread(latch);
        SimpleThread st2 = new SimpleThread(latch);
        SimpleThread st3 = new SimpleThread(latch);
        SimpleThread st4 = new SimpleThread(latch);
        st1.start();
        st2.start();
        st3.start();
        st4.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("We are in the main thread.");
    }
}
class SimpleThread extends Thread{

    private CountDownLatch latch;
    SimpleThread(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread Running"+super.getName());
        latch.countDown();
    }
}
