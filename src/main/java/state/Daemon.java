package state;

public class Daemon {
    public static void main(String[] args) {

        Thread god = new Thread(() -> {
            while(true) {
                System.out.println("上帝保佑着你！");
            }
        });

        Thread you = new Thread(() -> {
            for (int i = 0; i < 36; i++) {
                System.out.println("智伟大帅比！");
            }
            System.out.println("-=========goodbye! world!=========-");
        });

        // 默认是false表示用户线程，正常的线程都是用户线程
        god.setDaemon(true);

        god.start(); // 上帝守护线程启动
        you.start(); // 用户线程启动
    }
}

