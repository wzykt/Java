package leetCode.题目;

/**
 *有序数组中的单一元素
 *给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */

public class L_540 {
    public int singleNonDuplicate(int[] nums) {
//        int n= nums.length;
//        int l = 0,h=n-1;
//        int target = nums[n/2];
//        while(l <= n && l >= 0){
//            int m = l + (h-l)/2;
//            if(target==nums[m+1]||target==nums[m-1]){
//                l = m + 1;
//                continue;
//            }else{
//                h = m-1;
//            }
//            if(target!=nums[m+1]&&target!=nums[m-1]){
//                return nums[m];
//            }
//        }
//        return 0;

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        L_540 l = new L_540();
        int a[] = {1,1,2,3,3,4,4,8,8};
        int s = l.singleNonDuplicate(a);
        System.out.println(s);

    }
}
