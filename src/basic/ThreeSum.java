package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0; first < nums.length - 2; first++){
            if(nums[first] > 0) break;
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            int left = first + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[first] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[first],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
}
