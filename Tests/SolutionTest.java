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

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        sol = null;
        assertNull(sol);
    }



}