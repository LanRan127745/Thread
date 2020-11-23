package state;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
一直获取当前系统时间
 */
public class Sleep{

    public static void main(String[] args) {

        while(true){
            Date currentTime = new Date(System.currentTimeMillis()); // 获取当前系统时间
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(currentTime));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
