package 牛客.Offer;

public class JZ31 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i = n;i > 0;i--){
            int num = i;
            while(num > 0){
                if(num % 10 == 1){
                    count = count + 1;
                }
                num = num / 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = NumberOf1Between1AndN_Solution(14);
        System.out.println(i);
    }
}
