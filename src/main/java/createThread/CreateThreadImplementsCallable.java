package createThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

// 线程创建方式三：实现Callable接口
public class CreateThreadImplementsCallable implements Callable<Boolean> {
    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public CreateThreadImplementsCallable(String url,String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {

        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题!");
        }
        System.out.println("下载的文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable t1 = new CreateThreadImplementsCallable("https://img9.doubanio.com/view/photo/l/public/p2274198726.webp","十元4.jpg");
        Callable t2 = new CreateThreadImplementsCallable("https://img3.doubanio.com/view/photo/l/public/p2274198620.webp","十元5.jpg");
        Callable t3 = new CreateThreadImplementsCallable("https://img2.doubanio.com/view/photo/l/public/p2274198673.webp","十元6.jpg");

        // 创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行结果：
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        // 获取结果：
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        // 关闭服务：
        ser.shutdown();
    }
}
