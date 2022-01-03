import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(8);
        NewThread NT1 = new NewThread("1");
        NewThread NT2 = new NewThread("2");
        NewThread NT3 = new NewThread("3");
        NewThread NT4 = new NewThread("4");
        NewThread NT5 = new NewThread("5");
        NewThread NT6 = new NewThread("6");
        NewThread NT7 = new NewThread("7");
        NewThread NT8 = new NewThread("8");
        NewThread NT9 = new NewThread("9");
        NewThread NT10 = new NewThread("10");
        NewThread NT11 = new NewThread("11");
        NewThread NT12 = new NewThread("12");
        NewThread NT13 = new NewThread("13");
        NewThread NT14 = new NewThread("14");
        NewThread NT15 = new NewThread("15");
        NewThread NT16 = new NewThread("16");
        es.execute(NT1);
        es.execute(NT2);
        es.execute(NT3);
        es.execute(NT4);
        es.execute(NT5);
        es.execute(NT6);
        es.execute(NT7);
        es.execute(NT8);
        es.execute(NT9);
        es.execute(NT10);
        es.execute(NT11);
        es.execute(NT12);
        es.execute(NT13);
        es.execute(NT14);
        es.execute(NT15);
        es.execute(NT16);
        es.shutdown();
    }
}
class NewThread extends Thread{
    private String name = "";
    NewThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread get started, NO."+name);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread get finished, NO."+name);
    }

}
