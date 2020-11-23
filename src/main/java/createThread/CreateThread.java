package createThread;

public class CreateThread extends Thread {

    // 这段程序运行在分支线程中（分支栈）
    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // 这里是main()方法，这里的代码属于主线程，在主栈中运行
        // 创建一个分支线程对象
        Thread t1 = new CreateThread();

        // 使用匿名内部类的方式创建线程：new [匿名] extends Thread()
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++){
                    System.out.println("t2分支线程-->" + i);
                }
            }
        };

        // 调用start()方法开启线程
        t1.start();
        t2.start();

        // 这里的代码还是在主线程中运行
        for (int i = 0; i < 20; i++){
            System.out.println("我在学习多线程---" + i);
        }
    }
}