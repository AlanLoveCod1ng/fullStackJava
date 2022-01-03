public class WaitNotify {
    static public int balance = 0;

    public void withdraw(int amount) {
        synchronized (this){
            if(balance <= 0){
                try{

                    System.out.println("Waiting for balance updating.");
                    wait();
                }catch (InterruptedException e){
                    System.out.println("original balance: "+balance);
                    System.out.println("Withdrawal amount: "+ amount);

                    balance = balance - amount;
                    System.out.println("Withdrawal successfully and the current balance is "+ balance);
                    System.out.println("The thread got interrupt.");
                }
            }


        }

    }

    public void deposit(int amount){
        System.out.println("We are depositing the amount "+amount);
        balance = balance + amount;
    }

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        Thread t1 = new Thread(() -> wn.withdraw(1000));
        t1.setName("Thread 1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wn.deposit(2000);
            t1.interrupt();
        });
        t2.setName("Thread 2");
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
