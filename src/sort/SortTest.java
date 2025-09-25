package sort;

import java.util.Arrays;
import java.util.List;

public class SortTest {

    // 辅助方法：检查数组是否已经升序排序
    public static boolean isSorted(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 辅助方法：运行单个测试用例
    public static void runTest(Sortable sorter, int[] array) {
        // 为了不影响其他测试，我们复制一份原始数组进行排序
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        String sorterName = sorter.getClass().getSimpleName();
        System.out.println("--- Testing " + sorterName + " ---");
        System.out.println("Original array: " + Arrays.toString(arrayToSort));

        // 记录排序时间（可选，但很有用）
        long startTime = System.nanoTime();
        sorter.sort(arrayToSort);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // 转换为毫秒

        System.out.println("Sorted array:   " + Arrays.toString(arrayToSort));

        // 自动验证结果
        if (isSorted(arrayToSort)) {
            System.out.println("Result: PASSED");
        } else {
            // 如果失败，这是一个非常严重的问题，需要高亮显示
            System.err.println("Result: FAILED - Array is not sorted!");
        }
        System.out.println("Time taken: " + duration + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. 将所有需要测试的排序算法实例放入一个列表
        List<Sortable> sorters = List.of(
                new QuickSort(),
                new BinaryInsertion(),
                new DirectInsertion(),
                new ShellInsertion()
                // new BubbleSort(),  // 在这里添加你其他的排序实现
                // new QuickSort(),
                // new MergeSort()
        );

        // 2. 定义各种你需要测试的数组用例
        int[] case1_random = {3, 5, 2, 1, 3, 6, 2, 5};
        int[] case2_empty = {};
        int[] case3_single = {42};
        int[] case4_sorted = {1, 2, 3, 4, 5, 6, 7};
        int[] case5_reversed = {9, 8, 7, 6, 5, 4, 3};
        int[] case6_duplicates = {4, 1, 4, 2, 8, 2, 4, 1};
        int[] case7_all_same = {5, 5, 5, 5, 5, 5};
        int[] case8_with_negatives = {-5, 10, 0, -2, 3, 10};

        // 3. 循环遍历每一个排序算法，并用所有测试用例去测试它
        for (Sortable s : sorters) {
            runTest(s, case1_random);
            runTest(s, case2_empty);
            runTest(s, case3_single);
            runTest(s, case4_sorted);
            runTest(s, case5_reversed);
            runTest(s, case6_duplicates);
            runTest(s, case7_all_same);
            runTest(s, case8_with_negatives);
            System.out.println("--- Testing ---");
            s.sort(null);
            System.out.println("passed");
        }
    }
}