package basic;

public class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int k){
        int[] prefixSum = computePreFixSum(nums);
        int count = 0;
        int[] remainder = new int[k];
        for(int sum : prefixSum){
            int rem = (sum % k + k) % k;
            remainder[rem]++;
        }
        for(int i = 0; i < k; i++){
            count += remainder[i] * (remainder[i] - 1) / 2;
        }
        return count;
    }
    public int[] computePreFixSum(int[] nums){
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        return prefixSum;
    }
}
