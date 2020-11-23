package state;

public class Yield {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(),"a");
        Thread t2 = new Thread(new MyRunnable(),"b");

        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield(); // 线程礼让
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}