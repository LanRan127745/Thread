package createThread;

import java.util.Map;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}

interface Marry{
    void happyMarry();
}

// 真实角色，你去结婚
class You implements Marry {
    @Override
    public void happyMarry(){
        System.out.println("我要和新垣结衣结婚啦！！！");
    }
}

// 代理角色，帮助你结婚
class WeddingCompany implements Marry {
    // 代理谁 --> 真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry(){
        before();
        this.target.happyMarry(); // 真实对象
        after();
    }

    private void before() {
        System.out.println("结婚前：布置现场");
    }

    private void after() {
        System.out.println("结婚后：收尾款");
    }
}
