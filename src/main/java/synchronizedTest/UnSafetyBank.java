package synchronizedTest;

public class UnSafetyBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"结婚基金"); //银行账户
        Drawing you = new Drawing(account,500,"你");
        Drawing girlfriend = new Drawing(account,600,"girlfriend");

        girlfriend.start();
        you.start();
    }
}

class Account {
    int money; //余额
    String name; //用途

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行模拟取款
class Drawing extends Thread {
    Account account; // 银行账户
    int drawingMoney; // 取钱数
    int currentMoney; // 手上余额

    public Drawing(Account account,int drawingMoney,String name){
        super(name);// 调用父类的name属性
        this.account = account;
        this.drawingMoney = drawingMoney;// 需要取出的钱
    }

    // 取钱
    @Override
    public void run() {
        /*
        在这里使用了this对象作为synchronized的共享对象，肯定是错的
        因为这时候this没有指向account这个共享对象，在第四个案例的动力节点中的代码中
        两个线程是通过account这个共享对象来调用账户中取钱的方法，所以可以用this，但是这里不行
        只能用synchronized (account)，不能用synchronized (this)
         */
        // 判断钱是否足够
        if (account.money - drawingMoney < 0) {
            System.out.println(this.getName() + "想要取" + drawingMoney + "元，" + account.name + "余额为" + account.money + ",余额不足！");
            return;
        }

        //因为在这里会休眠0.5秒，所以每个线程都会判断余额是足够的（一个500一个600），也就是说两个线程的account.money都是100，这时候数据就是不安全的
/*        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        synchronized (account) {
            // 余额
            account.money = account.money - drawingMoney;
            // 手里的钱
            currentMoney += drawingMoney;
        }
        // Thread.currentThread().getName() = this.getName()
        // 因为Thread.currentThread() 返回的是一个Thread类型的对象，所以this指代的是Thread类型的对象
        System.out.println(this.getName() + "拿到了 " + currentMoney + " 块钱");
        System.out.println(account.name + "余额为：" + account.money);
    }
}