package 单例实现;

//静态内部类，线程安全
public class Singleton3 {

    private static final class SingletonHolder{
        private static final Singleton3 singleton = new Singleton3();
    }

    private Singleton3(){
    }

    public Singleton3 newSingleton3(){
        return SingletonHolder.singleton;
    }
}
