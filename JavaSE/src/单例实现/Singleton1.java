package 单例实现;

//懒汉式
//两种写法
public class Singleton1 {

    /*
    final关键字保证了线程的安全

    对于final，当你创建一个对象时，使用final关键字能够使得另一个线程不会访问到处于“部分创建”的对象
    因为：当构造函数退出时，final字段的值保证对访问构造对象的其他线程可见
    如果某个成员是final的，JVM规范做出如下明确的保证：
    一旦对象引用对其他线程可见，则其final成员也必须正确的赋值
    所以说借助于final，就如同你对对象的创建访问加锁了一般，天然的就保障了对象的安全发布。
     */

    private static final Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 newSingleton1() {
        return singleton;
    }


//    private static Singleton1 singleton1 = null;
//
//    static {
//        singleton1 = new Singleton1();
//    }
//
//    private Singleton1(){
//    }
//
//    public static Singleton1 newSingleton1(){
//        return singleton1;
//    }
//
}

