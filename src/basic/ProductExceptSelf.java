package basic;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] answer = new int[nums.length];
        int suffix = 1;
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }
        return answer;
    }
}
