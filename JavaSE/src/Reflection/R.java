package Reflection;

/*
体现Java的类似准动态语言的特性
 */
import java.util.List;
import java.util.Random;

public class R {

    public static void main(String[] args) throws Exception {
        R r = new R();
        String s = "";
        int num = new Random().nextInt(3);//0,1,2
        switch (num) {
            case 1:
                s = "java.util.List";
            case 2:
                s = "java.util.Date";
            case 0:
                s = "java.util.Random";
        }
        //通过传入数据的不同，会有不同的实例
        Object o = r.getInstance(s);
        System.out.println(o);

        R r1 = new R1();
        Object o1 = r1.getInstance("java.util.Random");
        System.out.println(o1);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });
    }

    //通过传入的instance来判断，构造哪一个对象。这也是大部分框架会使用反射的原因
    public Object getInstance(String instance) throws Exception {
        Class clazz = Class.forName(instance);
        Object obj = clazz.newInstance();
        return obj;
    }

}


class R1 extends R {
    public void to(){
        System.out.println("R1 extends R");
    }
}

class R2 extends R{
    public void to(){
        System.out.println("R2 extends R");
    }
}