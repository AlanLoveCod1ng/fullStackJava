public class VolatileDemo {
    volatile static int app = 0;
    public static void main(String[] args) {
        new Thread(()->{
            while(app==0){
                System.out.println("app hasn't change");
            }
            System.out.println("App has changed.");
        }).start();
        new Thread(()->{
            try{
                Thread.sleep(5000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            app = 1;
        }).start();
    }
}
