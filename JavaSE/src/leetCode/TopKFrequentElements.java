package leetCode;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            //key：遍历的值 value：遍历的值出现的次数
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        //数组下标代表遍历的值出现的次数，List中放的是遍历的值
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        //keySet()	返回 hashMap 中所有 key 组成的集合视图。
        //出现此数多的放在数组的高位，出现次数低的放在数组高位
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements tfs = new TopKFrequentElements();
        int[] a = {1,1,1,2,2,3};
        System.out.println(tfs.topKFrequent(a, 2));

    }
}
