package synchronizedTest;
// 不安全的购票
public class UnSafetyTicketGrabbing  {
    public static void main(String[] args) {
        Runnable buyTicket = new BuyTicket();
        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"老师").start();
        new Thread(buyTicket,"黄牛党").start();
    }
}

class BuyTicket implements Runnable {
    private int ticketNumber = 10; // 票
    boolean flag = true; // 外部停止方式
    @Override
    public void run() { while(flag){ buy(); } }

    // synchronized 同步方法，锁的是this，是buyTicket这个对象
    public synchronized void buy() {
        if(ticketNumber <= 0) {
            flag = false;
            return;
        }
        // 模拟延时
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNumber--);
    }
}

