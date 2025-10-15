package basic;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (remainderMap.containsKey(rem)) {
                if (i - remainderMap.get(rem) >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(rem, i);
            }
        }
        return false;
    }
}
