package threadPool;
import java.util.concurrent.*;
// 测试线程池
public class ImplementsRunnable {
    public static void main(String[] args) {
        //创建服务，创建线程池 （实现Runnable接口）
        //Executors:用于创建并返回不同类型的线程池
        //newFixedThreadPool 参数为线程池大小
        ExecutorService service1 = Executors.newFixedThreadPool(5);

        //执行Runnable接口的实现类 execute：执行任务，没有返回值，一般用来执行Runnable
        service1.execute(() -> { System.out.println(Thread.currentThread().getName()); });
        service1.execute(() -> { System.out.println(Thread.currentThread().getName()); });
        service1.execute(() -> { System.out.println(Thread.currentThread().getName()); });

        //关闭连接
        service1.shutdown();
    }
}
