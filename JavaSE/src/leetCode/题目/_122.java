package leetCode.题目;

/**
 * @date 2020-5-17
 * <p>
 * 买卖股票的最佳时机 II
 */
public class _122 {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {8, 7, 6, 4, 3, 1};
        int money1= process(arr1, 0, 0);
        int money2 = process(arr1, 0, 0);
        int money3= process(arr1, 0, 0);
        System.out.println(money1);
        System.out.println(money2);
        System.out.println(money3);
    }

    //
    public static int process(int[] prices, int money, int index) {
        if(index == prices.length){
            return money;
        }
        return 0;
    }
}
