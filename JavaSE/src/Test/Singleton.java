package Test;

import org.junit.Test;

public class Singleton {

    /*
    //饿汉式
    private static Test1 test = new Test1();

    private Test1(){
    }

    public static Test1 getInstance(){
        return test;
    }
     */


    /*
    private static Singleton singleton;

    private Singleton(){
    }

    public synchronized static Singleton getInstance(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    */

    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}