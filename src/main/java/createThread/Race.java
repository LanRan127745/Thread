package createThread;
// 模拟龟兔赛跑
public class Race implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for(int i = 1; i < 101; i++){

            // 模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i%10 == 0) {
                try{
                    Thread.sleep(20);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");

            if(gameOver(i))
                break;
        }
    }

    boolean gameOver(int step) {
        if(winner != null){ // 已有胜利者
            return true;
        }
        if(step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"小兔子").start();
        new Thread(race,"乌龟").start();
    }
}