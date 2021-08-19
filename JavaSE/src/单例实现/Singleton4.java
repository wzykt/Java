package 单例实现;

public class Singleton4 {

    private static volatile Singleton4 singleton4 = null;

    private Singleton4(){
    }

    public static synchronized Singleton4 newSingleton4(){
        if(singleton4 == null){
            synchronized (Singleton4.class){
                if (singleton4 == null){
                    return new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
