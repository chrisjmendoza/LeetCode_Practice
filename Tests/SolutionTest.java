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

        ListNode<Integer> n1 = new ListNode<>();
        ListNode<Integer> n2 = new ListNode<>();
        ListNode<Integer> n3 = new ListNode<>();
        ListNode<Integer> n4 = new ListNode<>();
        ListNode<Integer> n5 = new ListNode<>();
        ListNode<Integer> n6 = new ListNode<>();

        n1.value = 3;
        n1.next = n2;

        n2.value = 1;
        n2.next = n3;

        n3.value = 2;
        n3.next = n4;

        n4.value = 3;
        n4.next = n5;

        n5.value = 4;
        n5.next = n6;

        n6.value = 5;


        ListNode<Integer> m1 = new ListNode<>();
        ListNode<Integer> m2 = new ListNode<>();
        ListNode<Integer> m3 = new ListNode<>();
        ListNode<Integer> m4 = new ListNode<>();

        m1.value = 1;
        m1.next = m2;

        m2.value = 2;
        m2.next = m3;

        m3.value = 4;
        m3.next = m4;

        m4.value = 5;
        sol.removeKFromList(n1, 3);
        assertEquals(sol.removeKFromList(n1, 3), m1);
    }

    @Test
    public void testIsListPalindrome() {
        System.out.println("Running: testIsListPalindrome");
        ListNode<Integer> n1 = new ListNode<>();
        ListNode<Integer> n2 = new ListNode<>();
        ListNode<Integer> n3 = new ListNode<>();
        ListNode<Integer> n4 = new ListNode<>();
        ListNode<Integer> n5 = new ListNode<>();
        ListNode<Integer> n6 = new ListNode<>();

        n1.value = 1;
        n1.next = n2;

        n2.value = 1000000000;
        n2.next = n3;

        n3.value = -1000000000;
        n3.next = n4;

        n4.value = -1000000000;
        n4.next = n5;

        n5.value = 1000000000;
        n5.next = n6;

        n6.value = 1;

        assertEquals(sol.isListPalindrome(n1), true);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        sol = null;
        assertNull(sol);
    }



}