package threadPool;

import java.util.concurrent.*;

public class ImplementsCallableByThreadPool {
    public static void main(String[] args) {
        //创建服务，创建线程池 （实现Callable接口）
        ExecutorService service = Executors.newFixedThreadPool(3);

        //获得提交的执行结果,创建Future对象，传入实现Callable接口的对象，并重写call方法
        Future future = service.submit(() -> {
            System.out.println("callMethod...");
            return "return a object";
        });

        //获取返回值
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //关闭连接
        service.shutdown();
    }
}
