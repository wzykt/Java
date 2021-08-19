package 牛客.Offer;

import java.util.*;

/**
 * JZ32 把数组排成最小的数
 * <p>
 * 2021/7/26
 *
 * 完成：全排列判断
 */
public class JZ32 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return "";
        }

        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        process(numbers.length, 0, resultList, list);
        long result = Long.valueOf(resultList.get(0));
        System.out.println(resultList.toString());
        for (String s : resultList) {
            Long tem = Long.valueOf(s);
            if (result > tem) {
                result = tem;
            }
        }
        System.out.println(result);
        return result + "";
    }

    public static void process(int len, int index, List<String> temList, ArrayList<Integer> output) {
        if (index == len) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : output) {
                sb.append(i);
            }
            temList.add(sb.toString());
        }

        for (int i = index; i < len; i++) {
            Collections.swap(output, index, i);
            process(len, index + 1, temList, output);
            Collections.swap(output, index, i);
        }
    }

}
