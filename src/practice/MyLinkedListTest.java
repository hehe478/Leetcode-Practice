package practice;

public class MyLinkedListTest {

    public static void main(String[] args) {
        System.out.println("=============== MyLinkedList Test Suite ===============");
        System.out.println("注意：本测试基于代码审查后修正了所有已知bug的 MyLinkedList 版本。");

        testAdd();
        testRemove();
        testGetAndSet();
        testExceptions();

        System.out.println("\n=============== Test Suite Finished ===============");
    }

    // A helper function to print test results
    private static void printTestResult(String testName, boolean passed) {
        if (passed) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName);
        }
    }

    /**
     * Tests for addLast and add(index, element) methods
     */
    public static void testAdd() {
        System.out.println("\n--- Testing Add Operations ---");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // 1. Test addLast on an empty list
        list.addLast(10);
        boolean test1 = list.get(0).equals(10) && list.size == 1;
        printTestResult("addLast to an empty list", test1);

        // 2. Test addLast on a non-empty list
        list.addLast(20); // list should be [10, 20]
        boolean test2 = list.get(1).equals(20) && list.size == 2;
        printTestResult("addLast to a non-empty list", test2);

        // 3. Test add at the beginning (index 0)
        list.add(5, 0); // list should be [5, 10, 20]
        boolean test3 = list.get(0).equals(5) && list.size == 3;
        printTestResult("add to the beginning (index 0)", test3);

        // 4. Test add at the end (index size)
        list.add(30, 3); // list should be [5, 10, 20, 30]
        boolean test4 = list.get(3).equals(30) && list.size == 4;
        printTestResult("add to the end (index size)", test4);

        // 5. Test add in the middle
        list.add(15, 2); // list should be [5, 10, 15, 20, 30]
        boolean test5 = list.get(2).equals(15) && list.get(3).equals(20) && list.size == 5;
        printTestResult("add to the middle", test5);
    }

    /**
     * Tests for remove(index) and removeFirst methods
     */
    public static void testRemove() {
        System.out.println("\n--- Testing Remove Operations ---");
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E"); // list is [A, B, C, D, E]

        // 1. Test remove from the middle
        String removed1 = list.remove(2); // remove "C"
        boolean test1 = removed1.equals("C") && list.get(2).equals("D") && list.size == 4;
        printTestResult("remove from the middle", test1);

        // 2. Test remove from the beginning (index 0)
        String removed2 = list.remove(0); // remove "A"
        boolean test2 = removed2.equals("A") && list.get(0).equals("B") && list.size == 3;
        printTestResult("remove from the beginning", test2);

        // 3. Test remove from the end
        String removed3 = list.remove(2); // remove "E" (list is [B, D, E])
        boolean test3 = removed3.equals("E") && list.size == 2 && list.getLast().equals("D");
        printTestResult("remove from the end (and check tail pointer)", test3);

        // 4. Test removing the last remaining element
        list.remove(0); // remove "B"
        list.remove(0); // remove "D"
        boolean test4 = list.size == 0;
        printTestResult("remove until list is empty", test4);

        // 5. Test removing the only element
        list.addLast("Hello");
        list.remove(0);
        boolean test5 = list.size == 0;
        printTestResult("remove the only element", test5);
    }

    /**
     * Tests for get(index) and set(index, element) methods
     */
    public static void testGetAndSet() {
        System.out.println("\n--- Testing Get and Set Operations ---");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);

        // 1. Test get
        boolean test1 = list.get(0).equals(100) && list.get(1).equals(200) && list.get(2).equals(300);
        printTestResult("get first, middle, and last elements", test1);

        // 2. Test set
        Integer oldVal = list.set(1, 250); // set index 1 to 250
        boolean test2 = oldVal.equals(200) && list.get(1).equals(250) && list.size == 3;
        printTestResult("set element in the middle", test2);

        // 3. Test set at the beginning
        Integer oldVal2 = list.set(0, 50);
        boolean test3 = oldVal2.equals(100) && list.get(0).equals(50);
        printTestResult("set element at the beginning", test3);
    }

    /**
     * Tests for expected exceptions on invalid operations
     */
    public static void testExceptions() {
        System.out.println("\n--- Testing Exception Handling ---");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // 1. Test get on an empty list
        try {
            list.get(0);
            printTestResult("get from an empty list throws exception", false);
        } catch (IndexOutOfBoundsException e) {
            printTestResult("get from an empty list throws exception", true);
        }

        // 2. Test remove from an empty list
        try {
            list.remove(0);
            printTestResult("remove from an empty list throws exception", false);
        } catch (IndexOutOfBoundsException e) {
            printTestResult("remove from an empty list throws exception", true);
        }

        list.addLast(10); // list is [10]

        // 3. Test add with index > size
        try {
            list.add(10, 2);
            printTestResult("add with index > size throws exception", false);
        } catch (IndexOutOfBoundsException e) {
            printTestResult("add with index > size throws exception", true);
        }

        // 4. Test get with index >= size
        try {
            list.get(1);
            printTestResult("get with index >= size throws exception", false);
        } catch (IndexOutOfBoundsException e) {
            printTestResult("get with index >= size throws exception", true);
        }

        // 5. Test set with negative index
        try {
            list.set(-1, 99);
            printTestResult("set with negative index throws exception", false);
        } catch (IndexOutOfBoundsException e) {
            printTestResult("set with negative index throws exception", true);
        }
    }
}