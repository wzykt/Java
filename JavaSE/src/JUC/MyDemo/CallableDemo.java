package JUC.MyDemo;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Task task = new Task();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });

    }

}


class Task implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}