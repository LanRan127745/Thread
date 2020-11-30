package synchronizedTest;

import java.util.ArrayList;
import java.util.List;

// 线程不安全集合
// 原因:线程不安全原因：两个线程在添加到list集合中时，会重复添加到list集合中的同一个位置，因此会产生list集合中不到10000个数据
public class UnSafetyList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        // 创建10000个线程，添加得到list集合中
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                // 修改为线程安全的方式添加到集合中
                synchronized(list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        /*
        若主线程没有睡眠，可能会产生结果不是10000的可能
        因为主线程和其他线程并发执行，可能其他线程执行还没有结束，就是还没有将数据完全添加至集合中
        但是主线程已经执行结束，这个时候集合中的数据是没有 达到一百个的，因此size可能会没有达到10000这个结果
         */
        try {
            Thread.sleep(2000);        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
