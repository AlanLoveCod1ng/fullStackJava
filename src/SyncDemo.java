public class SyncDemo {

    public static void main(String[] args) throws InterruptedException{
        bracket b = new bracket();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i<5; i++){
                b.print();
                System.out.println();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i<5; i++){
                b.print();
                System.out.println();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1);
    }
}
class bracket{
    synchronized void print(){
        for(int i = 0; i<10; i++){
            if(i<5){
                System.out.print("[");
            }
            else{
                System.out.print("]");
            }
        }
    }
}