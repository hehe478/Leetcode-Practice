package basic;

public class MaxArea {
    public int maxArea(int[] height){
        if(height == null || height.length == 1) return -1;
        int left = 0;
        int right = height.length - 1;
        int maxCap = 0;
        int minHeight;
        while(left != right){
            minHeight = Math.min(height[left], height[right]);
            maxCap = Math.max(maxCap,(right - left) * minHeight);
            if(minHeight == height[left]) left++;
            else right--;
        }
        return maxCap;
    }
}
