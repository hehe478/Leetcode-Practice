package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. 创建结果列表
        List<List<Integer>> result = new ArrayList<>();

        // 2. 对数组进行排序，这是双指针算法的前提
        Arrays.sort(nums);

        // 3. 遍历数组，固定第一个数 a
        // 我们只需要遍历到倒数第三个数，因为后面需要留两个数 (b 和 c)
        for (int i = 0; i < nums.length - 2; i++) {

            // 优化：如果当前固定的数大于 0，因为数组已经排序，
            // 后面的数都比它大，三数之和不可能等于 0，可以直接结束循环。
            if (nums[i] > 0) {
                break;
            }

            // 去重：避免对同一个起始数进行重复计算。
            // 例如，如果数组是 [-1, -1, 0, 1]，当 i=0 时，我们计算了所有以第一个 -1 开头的组合。
            // 当 i=1 时，nums[i] 还是 -1，这种情况就应该跳过，否则会得到重复的结果。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 4. 设置双指针，分别指向 i 后面的区域的头部和尾部
            int left = i + 1;           // 左指针，指向 b
            int right = nums.length - 1; // 右指针，指向 c

            // 5. 移动双指针寻找 b 和 c
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到了一个符合条件的三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重：移动左右指针，跳过所有重复的 b 和 c
                    // 例如，对于 [-2, 0, 0, 2, 2]，当找到 [-2, 0, 2] 后，
                    // left 和 right 都需要跳过后面的重复值。
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动指针到下一个不同的元素
                    left++;
                    right--;

                } else if (sum < 0) {
                    // 和小于 0，说明 b 太小了，需要增大 b，所以左指针右移
                    left++;
                } else { // sum > 0
                    // 和大于 0，说明 c 太大了，需要减小 c，所以右指针左移
                    right--;
                }
            }
        }

        // 6. 返回最终结果
        return result;
    }
}
