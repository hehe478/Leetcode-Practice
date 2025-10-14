package practice;

import java.util.NoSuchElementException;

public class DoublyLinkedListTest {

    // 用于统计测试用例的计数器
    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        System.out.println("--- 开始测试 DoublyLinkedList ---");

        // 逐一运行测试模块
        testNewListIsEmpty();
        testAddLastAndGet();
        testAddAtIndex();
        testRemoveLast();
        testRemoveAtIndex();
        testSetMethods();
        testExceptionHandling();
        testChainedOperations();

        System.out.println("\n--- 测试结束 ---");
        System.out.println("总测试数: " + totalTests);
        System.out.println("通过数: " + passedTests);
        System.out.println("失败数: " + (totalTests - passedTests));

        if (totalTests == passedTests) {
            System.out.println("恭喜！所有测试用例均已通过！");
        } else {
            System.out.println("注意：有测试用例失败，请检查代码。");
        }
    }

    /**
     * 测试新创建的列表是否为空
     */
    public static void testNewListIsEmpty() {
        System.out.println("\n模块: [构造函数与空列表]");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        check(list.size() == 0, "新列表的 size 应该为 0");
    }

    /**
     * 测试 addLast 和 get 方法
     */
    public static void testAddLastAndGet() {
        System.out.println("\n模块: [addLast 和 get]");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("Apple");
        list.addLast("Banana");
        list.addLast("Cherry");

        check(list.size() == 3, "添加3个元素后 size 应为 3");
        check("Apple".equals(list.get(0)), "get(0) 应返回 'Apple'");
        check("Banana".equals(list.get(1)), "get(1) 应返回 'Banana'");
        check("Cherry".equals(list.get(2)), "get(2) 应返回 'Cherry'");
        check("Cherry".equals(list.getLast()), "getLast 应返回 'Cherry'");
    }

    /**
     * 测试 add(index) 方法
     */
    public static void testAddAtIndex() {
        System.out.println("\n模块: [add(index)]");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("A"); // [A]
        list.addLast("C"); // [A, C]
        list.add("B", 1);  // [A, B, C]
        check(list.get(1).equals("B") && list.size() == 3, "在中间添加 'B'");

        list.add("Start", 0); // [Start, A, B, C]
        check(list.get(0).equals("Start") && list.size() == 4, "在头部添加 'Start'");

        list.add("End", 4); // [Start, A, B, C, End]
        check(list.getLast().equals("End") && list.size() == 5, "在尾部添加 'End'");
    }

    /**
     * 测试 removeLast 方法
     */
    public static void testRemoveLast() {
        System.out.println("\n模块: [removeLast]");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("A");
        list.addLast("B");

        String removed = list.removeLast();
        check(removed.equals("B"), "removeLast 应返回 'B'");
        check(list.size() == 1, "移除一个元素后 size 应为 1");
        check(list.getLast().equals("A"), "新的尾部元素应为 'A'");
    }

    /**
     * 测试 remove(index) 方法
     */
    public static void testRemoveAtIndex() {
        System.out.println("\n模块: [remove(index)]");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("A"); list.addLast("B"); list.addLast("C"); list.addLast("D");

        String removed = list.remove(1); // 移除 "B"
        check(removed.equals("B"), "remove(1) 应返回 'B'");
        check(list.size() == 3, "移除后 size 应为 3");
        check(list.get(0).equals("A") && list.get(1).equals("C") && list.get(2).equals("D"), "移除中间元素后，其余元素顺序正确");
    }

    /**
     * 测试 set 和 setLast 方法
     */
    public static void testSetMethods() {
        System.out.println("\n模块: [set 和 setLast]");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10); list.addLast(20); list.addLast(30);

        list.set(99, 1);
        check(list.get(1) == 99, "set(1) 后，中间元素应为 99");
        check(list.size() == 3, "set 操作不应改变 size");

        list.setLast(100);
        check(list.getLast() == 100, "setLast 后，尾部元素应为 100");
    }

    /**
     * 测试异常处理逻辑
     */
    public static void testExceptionHandling() {
        System.out.println("\n模块: [异常处理]");
        DoublyLinkedList<String> emptyList = new DoublyLinkedList<>();
        DoublyLinkedList<String> singleItemList = new DoublyLinkedList<>();
        singleItemList.addLast("A");

        // 测试空列表异常
        checkThrows(emptyList::getLast, NoSuchElementException.class, "对空列表调用 getLast");
        checkThrows(emptyList::removeLast, NoSuchElementException.class, "对空列表调用 removeLast");

        // 测试索引越界异常
        checkThrows(() -> singleItemList.get(1), IndexOutOfBoundsException.class, "get(1) 在 size 为 1 的列表上");
        checkThrows(() -> singleItemList.get(-1), IndexOutOfBoundsException.class, "get(-1) 索引越界");
        checkThrows(() -> singleItemList.add("B", 2), IndexOutOfBoundsException.class, "add(2) 在 size 为 1 的列表上");
        checkThrows(() -> singleItemList.remove(1), IndexOutOfBoundsException.class, "remove(1) 在 size 为 1 的列表上");
    }

    /**
     * 测试一系列连续操作
     */
    public static void testChainedOperations() {
        System.out.println("\n模块: [综合链式操作]");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("A");  // ["A"]
        list.addLast("B");  // ["A", "B"]
        list.add("C", 2);   // ["A", "B", "C"]
        list.remove(1);     // ["A", "C"]
        list.add("D", 0);   // ["D", "A", "C"]
        list.setLast("E");  // ["D", "A", "E"]
        list.removeLast();  // ["D", "A"]

        boolean finalStateCorrect = list.size() == 2 && list.get(0).equals("D") && list.get(1).equals("A");
        check(finalStateCorrect, "一系列增删改后列表状态正确");
    }


    // --- 辅助方法 ---

    /**
     * 一个简单的断言方法，用于检查条件是否为真
     * @param condition 期望为真的条件
     * @param testName 测试的描述
     */
    private static void check(boolean condition, String testName) {
        totalTests++;
        if (condition) {
            System.out.println("  [PASS] " + testName);
            passedTests++;
        } else {
            System.out.println("  [FAIL] " + testName);
        }
    }

    /**
     * 检查一个代码块是否如期抛出了指定的异常
     * @param codeBlock 要执行的代码块 (使用 Lambda 表达式)
     * @param expectedException 期望抛出的异常类型
     * @param testName 测试的描述
     */
    private static void checkThrows(Runnable codeBlock, Class<? extends Throwable> expectedException, String testName) {
        totalTests++;
        try {
            codeBlock.run();
            // 如果代码执行到这里，说明没有抛出异常，测试失败
            System.out.println("  [FAIL] " + testName + " (未抛出预期的 " + expectedException.getSimpleName() + ")");
        } catch (Throwable caught) {
            // 捕获到了异常，检查异常类型是否匹配
            if (expectedException.isInstance(caught)) {
                System.out.println("  [PASS] " + testName + " (成功捕获 " + caught.getClass().getSimpleName() + ")");
                passedTests++;
            } else {
                System.out.println("  [FAIL] " + testName + " (抛出了错误的异常类型: " + caught.getClass().getSimpleName() + ")");
            }
        }
    }
}