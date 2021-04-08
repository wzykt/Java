package JVM;

public class HeapTuning {

    public static void main(String[] args) {

        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("Max内存："+max +"->"+(max/(double)1024/1024)+"MB");
        System.out.println("total内存："+total +"->"+(total/(double)1024/1024)+"MB");
    }
}
