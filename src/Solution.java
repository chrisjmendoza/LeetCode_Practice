import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a
     * specific target.
     * You may assume that each input would have exactly one solution, and you may not use the
     * same element twice.
     * @param nums array of integers
     * @param target the target sum
     * @return indices of the two numbers such that they add up to a specific target
     */
    int[] twoSum(int[] nums, int target) {
        int sum;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    /**
     * The Hamming distance between two integers is the number of positions at which the
     * corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * @param x The first value
     * @param y The second value
     * @return The number of position changes which the corresponding bits are different.
     */
    int hammingDistance(int x, int y) {

        int xBits = 0;
        int yBits = 0;

        int temp = x;

        while (temp != 0) {
            xBits++;
            temp /= 2;
        }

        temp = y;

        while (temp != 0) {
            yBits++;
            temp /= 2;
        }

        int max = xBits > yBits ? xBits : yBits;

        int counter = 0;

        for (int i = 0; i < max; i++, x /= 2, y /= 2) {
            if (x % 2 != y % 2) counter++;

        }
        return counter;
    }

    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this
     * robot makes a circle, which means it moves back to the original place.
     * <p>
     * The move sequence is represented by a string. And each move is represent by a character. The
     * valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or
     * false representing whether the robot makes a circle.
     *
     * @param moves The String representation of the robots moves.
     * @return True if the moves return to the original starting point (0,0) or false if not
     */
    boolean judgeCircle(String moves) {
        int upDown = 0;
        int leftRight = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    upDown++;
                    break;
                case 'D':
                    upDown--;
                    break;
                case 'L':
                    leftRight--;
                    break;
                case 'R':
                    leftRight++;
                    break;
            }
        }
        return upDown == 0 && leftRight == 0;
    }

    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some
     * nodes of the two trees are overlapped while the others are not.
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     * then sum node values up as the new value of the merged node. Otherwise, the NOT null node
     * will be used as the node of new tree.
     *
     * @param t1 The first root Node
     * @param t2 The second root Node
     * @return New root node
     */
    TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        TreeNode newNode;

        // Combine the two nodes into a new node with value t1.val + t2.val
        // If a node is null, use the NOT null node as the new value

        if(t1 == null && t2 == null) {
            return null;
        } else {
            if (t1 != null && t2 != null) {
                newNode = new TreeNode(t1.val + t2.val);
            } else if (t1 != null) {
                newNode = new TreeNode(t1.val);
            } else {
                newNode = new TreeNode(t2.val);
            }
        }

        // Go down the tree on both sides until both values are null

        // Go down the left, create a new node
       if(t1 != null && t2 != null) {
            newNode.left = mergeTrees(t1.left, t2.left);
       } else if(t1 != null) {
            newNode.left = mergeTrees(t1.left, null);
       } else {
            newNode.left = mergeTrees(null, t2.left);
       }


        // Go down the right
        if(t1 != null && t2 != null) {
            newNode.right = mergeTrees(t1.right, t2.right);
        } else if(t1 != null) {
            newNode.right = mergeTrees(t1.right, null);
        } else {
            newNode.right = mergeTrees(null, t2.right);
        }

        return newNode;
    }

    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some
     * nodes of the two trees are overlapped while the others are not.
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     * then sum node values up as the new value of the merged node. Otherwise, the NOT null node
     * will be used as the node of new tree.
     *
     * @param t1 The first root Node
     * @param t2 The second root Node
     * @return New root node
     */
    @Contract("!null, null -> !null")
    private TreeNode mergeTreesSolution(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTreesSolution(t1.left, t2.left);
        t1.right = mergeTreesSolution(t1.right, t2.right);
        return t1;
    }

    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n
     * as large as possible.
     * @param nums array of 2n integers
     * @return Sum of min(ai, bi) for all i from 1 to n as large as possible
     */
    int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        if(nums.length == 2) return Math.min(nums[0], nums[1]);
        for(int i = 0; i < nums.length / 2; i+=2) {
            int first = nums[i];
            int second = nums[i+1];
            int secondLast = nums[nums.length-2-i];
            int last = nums[nums.length-1-i];
            int temp = Math.min(first, second) + Math.min(secondLast, last);
            max = temp > max ? temp : max;
        }
        return max;
    }

    /**
     * Java's System.out.printf function can be used to print formatted output. The purpose of this
     * exercise is to test your understanding of formatting output using printf.
     *
     * To get you started, a portion of the solution is provided for you in the editor; you must
     * format and print the input to complete the solution.
     *
     * Input Format
     *
     * Every line of input will contain a String followed by an integer.
     * Each String will have a maximum of  alphabetic characters, and each integer will be in the
     * inclusive range from 0 to 999.
     *
     * Output Format
     *
     * In each line of output there should be two columns
     * The first column contains the String and is left justified using exactly  characters.
     * The second column contains the integer, expressed in exactly  digits; if the original input
     * has less than three digits, you must pad your output's leading digits with zeroes.
     *
     * Sample Input
     *
     * java 100
     * cpp 65
     * python 50
     *
     * Sample Output
     *
     * ================================
     * java           100
     * cpp            065
     * python         050
     * ================================
     *
     * Explanation
     *
     * Each String is left-justified with trailing whitespace through the first  characters. The
     * leading digit of the integer is the  character, and each integer that was less than  digits
     * now has leading zeroes.
     */
    void outputFormat() {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder("================================");
        System.out.println(output);
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            System.out.printf("%-15s", s1);
            System.out.printf("%03d", x);
            System.out.println("");
        }
    }

    /**
     * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in
     * such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the
     * grid all contain all of the numbers from 1 to 9 one time.
     *
     * Implement an algorithm that will check whether the given grid of numbers represents a valid
     * Sudoku puzzle according to the layout rules described above. Note that the puzzle
     * represented by grid does not have to be solvable.
     */
    boolean sudoku2(char[][] grid) {

        // Using a hashmap to store values in a given row, column, or box
        Map<Character, Boolean> gridCheck = new HashMap<>();

        // Brute force checking rows
        for(int j = 0; j < grid.length; j++) {
            gridCheck.clear();
            for(int i = 0; i < grid.length; i++) {
                if(grid[i][j]!='.') {
                    if(!gridCheck.containsKey(grid[i][j])) {
                        gridCheck.put(grid[i][j], true);
                    } else {
                        return false;
                    }
                }
            }
        }

        // Brute force checking columns
        for(int i = 0; i < grid.length; i++) {
            gridCheck.clear();
            for(int j = 0; j < grid.length; j++) {
                if(grid[i][j]!='.') {
                    if (!gridCheck.containsKey(grid[i][j])) {
                        gridCheck.put(grid[i][j], true);
                    } else {
                        return false;
                    }
                }
            }
        }

        // Checking Boxes
        gridCheck.clear();
        int countI, countJ;
        // Run for loop 9 times, once for each box
        for(int k = 0; k < 9; k++) {
            gridCheck.clear();
            // for each row of boxes, adjust the i and j values
            if(k < 3) {
                countI = 0;
                countJ = k * 3;
            } else if(k < 6) {
                countI = 3;
                int check = k % 3;
                if(check == 0) countJ = k - 3;
                else countJ = check == 1 ? 3 : 6;
            } else {
                countI = 6;
                int check = k % 6;
                if(check == 0) countJ = k - 3;
                else countJ = check == 1 ? 3 : 6;
            }
            for(int i = countI; i < countI + 3; i++) {
                for(int j = countJ; j < countJ + 3; j++) {
                    if(grid[i][j]!='.') {
                        if (!gridCheck.containsKey(grid[i][j])) {
                            gridCheck.put(grid[i][j], true);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean sudoku3(char[][] grid) {
        for(int i = 0; i < 9; i++) {
            char[] row = new char[9];
            char[] square = new char[9];
            char[] column = grid[i].clone();

            for(int j = 0; j < 9; j++) {
                row[j] = grid[j][i];
                square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if(!(validate(column) && validate(row) && validate(square)))
                return false;
        }
        return true;
    }

    boolean validate(char[] check) {
        StringBuilder i = new StringBuilder();
        Arrays.sort(check);
        for(char number : check) {
            if(i.toString().indexOf(number) != -1 && number != '.') return false;
            if(number != '.') {
                i.append(number);
            }
        }
        return true;
    }
}
