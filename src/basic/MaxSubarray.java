package basic;

public class MaxSubarray {
    public int maxSubArray(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        return findMaxSubArray(nums,0,nums.length - 1);
    }
    int findMaxSubArray(int[] nums ,int left ,int right){
        if(left == right){
            return(nums[left]);
        }
        int mid = left + (right - left) / 2;
        int leftMax = findMaxSubArray(nums,left,mid);
        int rightMax = findMaxSubArray(nums,mid + 1,right);

        int currentSum = 0;
        int leftBoardSum = Integer.MIN_VALUE;
        int rightBoardSum = Integer.MIN_VALUE;

        for(int i = mid; i >= left; i--){
            currentSum += nums[i];
            leftBoardSum = Math.max(currentSum,leftBoardSum);
        }
        currentSum = 0;
        for(int i = mid + 1; i <= right; i++){
            currentSum += nums[i];
            rightBoardSum = Math.max(currentSum,rightBoardSum);
        }
        int mergeSum = leftBoardSum + rightBoardSum;
        int result = Math.max(leftMax,rightMax);
        result = Math.max(mergeSum,result);
        return result;
    }
}
