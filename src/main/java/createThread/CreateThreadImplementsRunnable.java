package createThread;

// 创建方式2：实现Runnable接口，重写run方法，执行线程需要将
public class CreateThreadImplementsRunnable {
    public static void main(String[] args) {
        // 创建一个可运行类的对象
        Runnable runnable = new CreateRunnable();
        // 将一个可运行的对象封装成一个线程对象
        Thread t1 = new Thread(runnable);
        t1.start();

        // 匿名内部类
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    System.out.println("分支线程t2-->" + i);
                }
            }
        });


        // 省略写法；将上面三行代码省略一行写法
        // new Thread(new CreateRunnable()).start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main主线程-->" + i);
        }
    }
}

// 定义一个可运行类,不是一个线程类
class CreateRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++){
            System.out.println("分支线程t1-->" + i);
        }
    }
}
