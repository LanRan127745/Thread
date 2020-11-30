package threadPool;

import java.util.concurrent.*;

public class ImplementsCallableByThread{

    public static void main(String[] args) {
        //2。 创建FutureTask对象，传入实现Callable接口的对象，并重写call方法
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("callMethod...");
            return "return a object";
        });

        //2.1.1 创建并启动线程对象
        new Thread(futureTask).start();

        //2.1.2 获取返回值
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
