import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution sol = new Solution();
    private final int[] arr = {2, 7, 11, 15};
    private final int target = 9;
    private final int[] answer = {0, 1};
    private final int[] smallArr = {1, 4, 3, 2};
    private final int[] smallArr2 = {7, 3, 1, 0, 0, 6};

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
    }

    @Test
    public void testTwoSum() {
        System.out.println("Running: twoSum");
        assertArrayEquals(sol.twoSum(arr, target), answer);
    }

    @Test
    public void testHammingDistance() {
        System.out.println("Running: hammingDistance");
        assertEquals(sol.hammingDistance(1, 4), 2);
    }

    @Test
    public void testJudgeCircle() {
        System.out.println("Running: judgeCircle");
        assertEquals(sol.judgeCircle("LL"), false);
        assertEquals(sol.judgeCircle("LRUD"), true);
    }

    @Test
    public void testMergeTrees() {
        //TODO Write method test for mergeTrees
    }

    @Test
    public void testArrayPairSum() {
        System.out.println("Running: arrayPairSum");
        assertEquals(sol.arrayPairSum(smallArr), 4);
        assertEquals(sol.arrayPairSum(smallArr2), 7);
    }

    @Test
    public void testOutputFormat() {
        System.out.println("Running: outputFormat");
        String test = "================================\n" +
                "java           100 \n" +
                "cpp            065 \n" +
                "python         050 \n" +
                "================================";
    }

    @Test
    public void testSudoku2() {
        System.out.println("Running: testSudoku2");
        char[][] sudoku = {{'2','9','5','1','4','6','.','.','.'},
                           {'1','.','.','.','.','3','6','.','.'},
                           {'.','.','3','.','.','7','.','.','.'},
                           {'.','.','.','.','.','8','.','.','.'},
                           {'.','.','.','7','.','9','.','.','.'},
                           {'3','.','.','.','5','2','.','.','.'},
                           {'.','.','7','.','.','4','.','.','.'},
                           {'.','.','.','.','.','1','.','.','.'},
                           {'.','.','.','.','7','5','.','.','.'}};
        assertEquals(sol.sudoku2(sudoku), true);
    }

    @Test
    public void testSudoku3() {
        System.out.println("Running: testSudoku3");
        char[][] sudoku = {{'.','9','.','.','4','.','.','.','.'},
                {'1','.','.','.','.','.','6','.','.'},
                {'.','.','3','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','7','.','.','.','.','.'},
                {'3','.','.','.','5','.','.','.','.'},
                {'.','.','7','.','.','4','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','7','.','.','.','.'}};
        assertEquals(sol.sudoku3(sudoku), true);
    }

    @Test
    public void testIsCryptSolution() {
        System.out.println("Running: testIsCryptSolution");
        String[] cryptOne = {"TEN", "TWO", "ONE"};
        char[][] solutionOne = {{'O', '1'}, {'T', '0'}, {'W', '9'}, {'E', '5'}, {'N', '4'}};

        String[] cryptTwo = {"SEND", "MORE", "MONEY"};
        char[][] solutionTwo = {{'O', '0'}, {'M', '1'}, {'Y', '2'}, {'E', '5'}, {'N', '6'}, {'D', '7'}, {'R', '8'}, {'S', '9'}};

        String[] cryptThree = {"A", "A", "A"};
        char[][] solutionThree = {{'A','0'}};

        String[] cryptFour = {"AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC"};
        char[][] solutionFour = {{'A','0'}, {'B','1'}, {'C','2'}};

        String[] cryptFive = {"AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC"};
        char[][] solutionFive = {{'A','1'}, {'B','2'}, {'C','3'}};

        assertEquals(sol.isCryptSolution(cryptOne, solutionOne), false);
        assertEquals(sol.isCryptSolution(cryptTwo, solutionTwo), true);
        assertEquals(sol.isCryptSolution(cryptThree, solutionThree), true);
        assertEquals(sol.isCryptSolution(cryptFour, solutionFour), false);
        assertEquals(sol.isCryptSolution(cryptFive, solutionFive), true);

        assertEquals(sol.isCryptSolution2(cryptOne, solutionOne), false);
        assertEquals(sol.isCryptSolution2(cryptTwo, solutionTwo), true);
        assertEquals(sol.isCryptSolution2(cryptThree, solutionThree), true);
        assertEquals(sol.isCryptSolution2(cryptFour, solutionFour), false);
        assertEquals(sol.isCryptSolution2(cryptFive, solutionFive), true);
    }

    @Test
    public void testRemoveKFromList() {
        System.out.println("Running: testRemoveKFromList");

        ListNode<Integer> n1 = new ListNode<>(3);
        ListNode<Integer> n2 = new ListNode<>(1);
        ListNode<Integer> n3 = new ListNode<>(2);
        ListNode<Integer> n4 = new ListNode<>(3);
        ListNode<Integer> n5 = new ListNode<>(4);
        ListNode<Integer> n6 = new ListNode<>(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n6.value = 5;


        ListNode<Integer> m1 = new ListNode<>(1);
        ListNode<Integer> m2 = new ListNode<>(2);
        ListNode<Integer> m3 = new ListNode<>(4);
        ListNode<Integer> m4 = new ListNode<>(5);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        sol.removeKFromList(n1, 3);
        assertEquals(sol.removeKFromList(n1, 3), m1);
    }

    @Test
    public void testIsListPalindrome() {
        System.out.println("Running: testIsListPalindrome");
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(1000000000);
        ListNode<Integer> n3 = new ListNode<>(-1000000000);
        ListNode<Integer> n4 = new ListNode<>(-1000000000);
        ListNode<Integer> n5 = new ListNode<>(1000000000);
        ListNode<Integer> n6 = new ListNode<>(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        assertEquals(sol.isListPalindrome(n1), true);
    }

    @Test
    public void testAddTwoHugeNumbers() {
        ListNode<Integer> n1 = new ListNode<>(9876);
        ListNode<Integer> n2 = new ListNode<>(5432);
        ListNode<Integer> n3 = new ListNode<>(1999);

        n1.next = n2;
        n2.next = n3;

        ListNode<Integer> m1 = new ListNode<>(1);
        ListNode<Integer> m2 = new ListNode<>(8001);

        m1.next = m2;

        ListNode<Integer> a1 = new ListNode<>(1);
        ListNode<Integer> a2 = new ListNode<>(2);
        ListNode<Integer> a3 = new ListNode<>(3);

        a1.next = a2;
        a2.next = a3;

        ListNode<Integer> b1 = new ListNode<>(3);
        ListNode<Integer> b2 = new ListNode<>(4);
        ListNode<Integer> b3 = new ListNode<>(5);

        b1.next = b2;
        b2.next = b3;

        ListNode<Integer> z1 = new ListNode<>(0);
        ListNode<Integer> y1 = new ListNode<>(0);

        ListNode<Integer> x1 = new ListNode<>(9999);
        ListNode<Integer> x2 = new ListNode<>(9999);
        ListNode<Integer> x3 = new ListNode<>(9999);
        ListNode<Integer> x4 = new ListNode<>(9999);
        ListNode<Integer> x5 = new ListNode<>(9999);

        ListNode<Integer> one = new ListNode<>(1);

        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;
//
//        sol.addTwoHugeNumbers(n1, m1);
//        sol.addTwoHugeNumbers(a1, b1);
//        sol.addTwoHugeNumbers(y1, z1);
//        sol.addTwoHugeNumbers(one, x1);

        sol.addTwoHugeNumbers2(n1, m1);
        sol.addTwoHugeNumbers2(a1, b1);
        sol.addTwoHugeNumbers2(y1, z1);
        sol.addTwoHugeNumbers2(one, x1);
    }

    @Test
    public void testMergeTwoLinkedLists() {
        System.out.println("Running: testMergeTwoLinkedLists");
        ListNode<Integer> a1 = new ListNode<>(1);
        ListNode<Integer> a2 = new ListNode<>(2);
        ListNode<Integer> a3 = new ListNode<>(3);

        a1.next = a2;
        a2.next = a3;

        ListNode<Integer> b1 = new ListNode<>(4);
        ListNode<Integer> b2 = new ListNode<>(5);
        ListNode<Integer> b3 = new ListNode<>(6);

        b1.next = b2;
        b2.next = b3;

        sol.mergeTwoLinkedLists(a1, b1);
    }

    @Test
    public void testReverseNodesInKGroups() {
        System.out.println("Running: testReverseNodesInKGroups");
        ListNode<Integer> a1 = new ListNode<>(1);
        ListNode<Integer> a2 = new ListNode<>(2);
        ListNode<Integer> a3 = new ListNode<>(3);
        ListNode<Integer> a4 = new ListNode<>(4);
        ListNode<Integer> a5 = new ListNode<>(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        sol.reverseNodesInKGroups(a1, 3);
    }

    @Test
    public void testRearrangeLastN() {
        System.out.println("Running: testRearrangeLastN");
        ListNode<Integer> a1 = new ListNode<>(1);
        ListNode<Integer> a2 = new ListNode<>(2);
        ListNode<Integer> a3 = new ListNode<>(3);
        ListNode<Integer> a4 = new ListNode<>(4);
        ListNode<Integer> a5 = new ListNode<>(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        sol.rearrangeLastN(a1, 3);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        sol = null;
        assertNull(sol);
    }

}