package leetCode;
/*
盛最多水的容器

关键字：左右移动
模式识别：需要移动左右两头的问题可以考虑双指针法

指针分别指向最左侧和最右侧
因为区域受限于较短边，当右边高度大于左边时，固定右边，移动左边
 */
public class _11 {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int begin = 0;
        int end = height.length-1;
        int area = 0;
        while (begin < end){
            if(height[begin] > height[end]){
                area = height[end]*(end-begin);
                end--;
            }else {
                area = height[begin]*(end-begin);
                begin++;
            }
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
