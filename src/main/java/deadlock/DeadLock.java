package deadlock;
// 死锁：多个线程各自占有一些公共资源，有可能形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Object lipstick = new Object(); // 口红
        Object  mirror  = new Object(); // 镜子

        new Makeup(lipstick,mirror,"邓紫棋",1).start();
        new Makeup(lipstick,mirror,"蔡依林",0).start();
    }
}

class Makeup extends Thread {
    Object lipstick;
    Object mirror;
    int priority;

    Makeup(Object lipstick ,Object mirror ,String girlName,int priority) {
        super(girlName);
        this.lipstick = lipstick;
        this.mirror = mirror;
        this.priority = priority;
    }

    @Override
    public void run() {
        if(priority > 0){ // 优先级高，先拿到口红，等待0.5秒
            synchronized (lipstick){
                System.out.println(Thread.currentThread().getName() + "获得了口红~");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + "正在等待其他人用完镜子~");
                synchronized (mirror){
                    System.out.println(Thread.currentThread().getName() + "获得了镜子，开始化妆啦！");
                }
            }
        }
        synchronized (mirror){
            System.out.println(Thread.currentThread().getName() + "获得了镜子~");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "正在等待其他人用完口红~");
            synchronized (lipstick){
                System.out.println(Thread.currentThread().getName() + "获得了口红，开始化妆啦！");
            }
        }
    }
}