package createThread;

// 买火车票的例子：多个线程同时操作同一个对象
// 发现问题：多个线程同时操作同一个资源时，线程不安全，发生数据紊乱
public class TicketGrabbing implements Runnable{

    private int ticket = 10; // 火车票数

    @Override
    public void run() {
        while(true){
            if(ticket <= 0)
                break;

            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new TicketGrabbing();

        // name表示线程的名称
        new Thread(runnable,"小明").start();
        new Thread(runnable,"老师").start();
        new Thread(runnable,"黄牛").start();
    }
}
