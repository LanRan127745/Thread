package lambda;
/*
推导lambda表达式
 */
public class Lambda {

    // 3.静态内部类
    static class Like1 implements ILike {
        @Override
        public void lambda(String str) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like.lambda("i like lambda");

        ILike like1 = new Like1();
        like1.lambda("静态内部类：i like lambda1");

        // 4.局部内部类 内部类需要写在实例化该对象表达式之前
        class Like2 implements ILike {
            @Override
            public void lambda(String str) {
                System.out.println(str);
            }
        }

        ILike like2 = new Like2();
        like2.lambda("局部内部类：i like lambda2");

        // 5.匿名内部类 没有类的名称，必须借助接口或父类    new [匿名] implements ILike(){};
        ILike like3 = new ILike() {
            @Override
            public void lambda(String str) {
                System.out.println(str);
            }
        };
        like3.lambda("匿名内部类：i like lambda3");

        // 6.使用lambda简化
        ILike like4 = (String str) -> {
            System.out.println(str);
        };
        like4.lambda("lambda表达式：i like lambda4");

        // 7.简化参数类型,多个参数同样适用
        like4 = (str) -> {
            System.out.println(str);
        };

        // 8.简化括号，当参数个数只有一个的时候才能使用
        like4 = str -> {
            System.out.println(str);
        };

        // 9.当方法体内只有一行代码时，可以去掉花括号
        like4 = str -> System.out.println(str);
    }
}

// 1.定义一个函数式接口
interface ILike {
    void lambda(String str);
}

// 2.实现类
class Like implements ILike {
    @Override
    public void lambda(String str){
        System.out.println(str);
    }
}
