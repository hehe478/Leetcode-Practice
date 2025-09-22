package practice;

public class MyArrayListTest {
    public static void main(String[] args) {
        System.out.println("=== 开始测试MyArrayList ===");

        // 1. 测试构造函数和初始状态
        testConstructor();

        // 2. 测试add和get方法
        testAddAndGet();

        // 3. 测试insert方法
        testInsert();

        // 4. 测试set方法
        testSet();

        // 5. 测试remove方法
        testRemove();

        // 6. 测试扩容功能
        testResizeExpand();

        // 7. 测试缩容功能
        testResizeShrink();

        // 8. 测试异常情况
        testExceptions();

        // 9. 测试排序功能
        testSort();

        System.out.println("=== 所有测试完成 ===");
    }

    // 测试构造函数
    private static void testConstructor() {
        System.out.println("\n--- 测试构造函数 ---");
        MyArrayList<Integer> list1 = new MyArrayList<>();
        System.out.println("默认构造函数 - 初始size: " + list1.size() + " (预期: 0)");

        MyArrayList<String> list2 = new MyArrayList<>(5);
        System.out.println("指定容量构造函数 - 初始size: " + list2.size() + " (预期: 0)");

        MyArrayList<Double> list3 = new MyArrayList<>(-3); // 测试负数容量处理
        System.out.println("负数容量构造函数 - 应使用默认容量 (无异常即为正常)");
    }

    // 测试add和get方法
    private static void testAddAndGet() {
        System.out.println("\n--- 测试add和get ---");
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("添加3个元素后size: " + list.size() + " (预期: 3)");
        System.out.println("获取索引1的元素: " + list.get(1) + " (预期: Banana)");
        System.out.println("获取索引2的元素: " + list.get(2) + " (预期: Cherry)");
    }

    // 测试insert方法
    private static void testInsert() {
        System.out.println("\n--- 测试insert ---");
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(30);
        list.insert(1, 20); // 在中间插入
        list.insert(0, 5);  // 在开头插入
        list.insert(4, 35); // 在末尾插入

        System.out.print("插入后元素序列: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // 预期: 5 10 20 30 35
        }
        System.out.println();
    }

    // 测试set方法
    private static void testSet() {
        System.out.println("\n--- 测试set ---");
        MyArrayList<Double> list = new MyArrayList<>();

        list.add(1.1);
        list.add(2.2);
        list.set(1, 9.9); // 修改索引1的元素

        System.out.println("修改后索引1的元素: " + list.get(1) + " (预期: 9.9)");
    }

    // 测试remove方法
    private static void testRemove() {
        System.out.println("\n--- 测试remove ---");
        MyArrayList<String> list = new MyArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        list.remove(1); // 删除中间元素
        System.out.print("删除索引1后元素: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // 预期: A C D
        }
        System.out.println();

        list.remove(0); // 删除首元素
        System.out.print("删除索引0后元素: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // 预期: C D
        }
        System.out.println();
    }

    // 测试扩容功能
    private static void testResizeExpand() {
        System.out.println("\n--- 测试扩容 ---");
        MyArrayList<Integer> list = new MyArrayList<>(2); // 初始容量2

        list.add(1);
        list.add(2);
        System.out.println("添加2个元素后 - 未扩容 (无异常即为正常)");

        list.add(3); // 触发扩容
        System.out.println("添加第3个元素后 - 扩容成功 (无异常即为正常)");
        System.out.println("扩容后元素: " + list.get(0) + "," + list.get(1) + "," + list.get(2)
                + " (预期: 1,2,3)");
    }

    // 测试缩容功能
    private static void testResizeShrink() {
        System.out.println("\n--- 测试缩容 ---");
        MyArrayList<Integer> list = new MyArrayList<>(4); // 初始容量4

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4); // 填满容量

        list.remove(3);
        list.remove(2); // 剩余2个元素，达到缩容条件
        System.out.println("删除元素后 - 缩容成功 (无异常即为正常)");
        System.out.println("缩容后元素: " + list.get(0) + "," + list.get(1) + " (预期: 1,2)");
    }

    // 测试异常情况
    private static void testExceptions() {
        System.out.println("\n--- 测试异常处理 ---");
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Test");

        // 测试越界get
        try {
            list.get(1);
            System.out.println("get越界测试 - 失败 (未抛出异常)");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get越界测试 - 成功 (正确抛出异常)");
        }

        // 测试越界insert
        try {
            list.insert(-1, "Error");
            System.out.println("insert负数索引测试 - 失败 (未抛出异常)");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("insert负数索引测试 - 成功 (正确抛出异常)");
        }

        // 测试越界remove
        try {
            list.remove(2);
            System.out.println("remove越界测试 - 失败 (未抛出异常)");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("remove越界测试 - 成功 (正确抛出异常)");
        }
    }

    // 测试排序功能
    private static void testSort() {
        System.out.println("\n--- 测试排序功能 ---");

        // 测试1: 对多个元素进行排序
        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(9);
        list1.add(1);
        list1.add(5);
        list1.add(6);

        System.out.print("排序前元素: ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        list1.sort();

        System.out.print("排序后元素: ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " "); // 预期: 1 2 5 5 6 9
        }
        System.out.println();

        // 测试2: 对空列表排序
        MyArrayList<Integer> emptyList = new MyArrayList<>();
        try {
            emptyList.sort();
            System.out.println("空列表排序测试 - 成功 (无异常)");
        } catch (Exception e) {
            System.out.println("空列表排序测试 - 失败 (抛出异常: " + e.getMessage() + ")");
        }

        // 测试3: 对单个元素排序
        MyArrayList<Integer> singleElementList = new MyArrayList<>();
        singleElementList.add(100);
        singleElementList.sort();
        System.out.println("单个元素排序后: " + singleElementList.get(0) + " (预期: 100)");

        // 测试4: 对已排序的列表排序
        MyArrayList<Integer> sortedList = new MyArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.sort();
        System.out.print("已排序列表再次排序后: ");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.print(sortedList.get(i) + " "); // 预期: 1 2 3 4
        }
        System.out.println();

        // 测试5: 对逆序列表排序
        MyArrayList<Integer> reverseList = new MyArrayList<>();
        reverseList.add(4);
        reverseList.add(3);
        reverseList.add(2);
        reverseList.add(1);
        reverseList.sort();
        System.out.print("逆序列表排序后: ");
        for (int i = 0; i < reverseList.size(); i++) {
            System.out.print(reverseList.get(i) + " "); // 预期: 1 2 3 4
        }
        System.out.println();

        // 测试6: 非Integer类型调用排序方法
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("Banana");
        stringList.add("Apple");
        try {
            stringList.sort();
            System.out.println("非Integer类型排序测试 - 失败 (未抛出异常)");
        } catch (IllegalStateException e) {
            System.out.println("非Integer类型排序测试 - 成功 (正确抛出异常)");
        } catch (Exception e) {
            System.out.println("非Integer类型排序测试 - 失败 (抛出非预期异常: " + e.getClass() + ")");
        }
    }
}
