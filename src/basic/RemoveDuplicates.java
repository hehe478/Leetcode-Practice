package basic;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int differentNum = 1;
        int nextPos = 0;
        if(nums.length == 0) return 0;

        for(;differentNum < nums.length;differentNum++){
            if(nums[differentNum] != nums[nextPos]){
                nums[++nextPos] = nums[differentNum];
            }
        }
        return ++nextPos;
    }
}
