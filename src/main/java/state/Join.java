package state;

public class Join implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("VIP线程" + i + "号来了！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Join());
        t.start();

        for (int i = 1; i <= 6; i++) {
            if(i == 2)
                t.join();
            System.out.println("main" + i);
        }
    }
}
