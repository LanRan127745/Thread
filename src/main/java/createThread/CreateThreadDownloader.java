package createThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class CreateThreadDownloader extends Thread{
    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public CreateThreadDownloader(String url,String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名为：" + name);
    }

    public static void main(String[] args) {
        Thread t1 = new CreateThreadDownloader("https://img9.doubanio.com/view/photo/l/public/p2274198726.webp","十元1.jpg");
        Thread t2 = new CreateThreadDownloader("https://img3.doubanio.com/view/photo/l/public/p2274198620.webp","十元2.jpg");
        Thread t3 = new CreateThreadDownloader("https://img2.doubanio.com/view/photo/l/public/p2274198673.webp","十元3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

// 下载器
class WebDownloader {
    // 下载方法
    public void downloader(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题!");
        }
    }
}