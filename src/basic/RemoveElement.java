package basic;

public class RemoveElement {
    public int removeElement(int[] nums, int val){
        int findNotVal = 0;
        int nextPos = 0;
        for(; findNotVal < nums.length; findNotVal++){
            if(nums[findNotVal] != val){
                nums[nextPos] = nums[findNotVal];
                nextPos++;
            }
        }
        return nextPos;
    }
}
