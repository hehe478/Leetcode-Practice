package basic;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k % n == 0) {
            return;
        }
        k = k % n;

        // 步骤 1: 计算最大公约数，也就是需要启动的循环次数
        int count = gcd(n, k);

        // 步骤 2: 外层循环，启动每个独立的链条
        for (int start = 0; start < count; start++) {
            int currentIndex = start;
            int valueToMove = nums[start];

            // 步骤 3: 内层 do-while 循环，完成一次循环替换
            do {
                int nextIndex = (currentIndex + k) % n;

                // "接住"下一个位置的元素
                int temp = nums[nextIndex];
                // 把手里的元素放到新位置
                nums[nextIndex] = valueToMove;

                // 更新手里的元素和当前位置
                valueToMove = temp;
                currentIndex = nextIndex;
            } while (currentIndex != start); // 直到链条闭合
        }
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
