package Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetMethodTest {

    @Test
    public void getField() throws Exception {

        Class clazz = R.class;
        //通过newInstance获取实例
        R r = (R) clazz.newInstance();
        //拿到名为number的字段
        Field field = clazz.getDeclaredField("number");
        //保证当前属性是可以访问的，即可以访问到private标识的字段
        field.setAccessible(true);
        //参数1：设置那个对象的属性，参数二：给对象的字段赋值
        field.set(r,1000);
        System.out.println(field.get(r));
    }

    @Test
    public void getMethod() throws Exception {

        Class clazz = R.class;
        //通过newInstance获取实例
        R r = (R) clazz.newInstance();
        //拿到名为getInstance的方法，参数二：参数列表的类型
        Method method = clazz.getDeclaredMethod("getInstance", String.class);
        //保证当前属性是可以访问的，即可以访问到private标识的方法
        method.setAccessible(true);
        //使用invoke()方法执行方法，并返回值
        Object invoke = method.invoke(r,"com.util.Date");
        System.out.println(invoke);
    }


}
