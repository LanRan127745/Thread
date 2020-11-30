package deadlock;

import java.util.concurrent.locks.ReentrantLock;

// 测试Lock锁
public class Lock {
    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        new Thread(lockThread).start();
        new Thread(lockThread).start();
        new Thread(lockThread).start();
    }
}

class LockThread implements Runnable {
    int ticketAmount = 100;

    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock(); //加锁
            try {
                if (ticketAmount > 0){
                    System.out.println(Thread.currentThread().getName() + "-->" + ticketAmount--);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }else{
                    break;
                }
            }finally {
                lock.unlock();//解锁
            }
        }
    }
}