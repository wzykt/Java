package 单例实现;

//饿汉式  线程安全
//newSingleton2加上synchronized，final关键字去掉，就是线程安全的了。
public class Singleton2 {

    private static final Singleton2 singleton2 = null;

    private Singleton2() {
    }

    public Singleton2 newSingleton2() {
        if (singleton2 == null) {
            return new Singleton2();
        }
        return singleton2;
    }
/*

//饿汉式  线程不安全
//少了final和synchronized关键字
    private static Singleton2 singleton2 = null;

    private Singleton2(){
    }

    public Singleton2 synchronized newSingleton2(){
        if(singleton2 == null){
            return new Singleton2();
        }
        return singleton2;
    } */
}
