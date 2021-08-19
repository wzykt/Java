package leetCode.题目;

public class color_75 {
    public int[] sortColors(int[] nums) {
        int length = nums.length;
        //target用户来判断0出现的次数
        int target=0;
        int[] numsSorted = new int[length];
        int begin = 0,end = length;
        for(int i = 0; i<length;i++){
            if(nums[i]==0){
                numsSorted[begin] = nums[i];
                begin++;
                target++;
            }
            if(nums[i]==2){
                numsSorted[end-1] = nums[i];
                end--;
            }
        }
        //将从第target开始的数组赋值为1
        for(int i = 0; i<length;i++){
            if(i>target-1&&numsSorted[i]==0){
                numsSorted[i]=1;
            }
        }
        return numsSorted;
    }

    public static void main(String[] args) {
        color_75  color_75 = new color_75();
        int a[] = {2,0,1};
        for (int i:color_75.sortColors(a)) {
            System.out.print(i+",");
        }
    }
}
/*
其他方法

public void sortColors(int[] nums) {
    int zero = -1, one = 0, two = nums.length;
    while (one < two) {
        if (nums[one] == 0) {
            swap(nums, ++zero, one++);
        } else if (nums[one] == 2) {
            swap(nums, --two, one);
        } else {
            ++one;
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
 */