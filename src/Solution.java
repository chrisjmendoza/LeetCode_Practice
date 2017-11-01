import javafx.util.converter.BigIntegerStringConverter;
import org.jetbrains.annotations.Contract;

import java.math.BigInteger;
import java.util.*;

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

    /**
     * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in
     * such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the
     * grid all contain all of the numbers from 1 to 9 one time.
     *
     * Implement an algorithm that will check whether the given grid of numbers represents a valid
     * Sudoku puzzle according to the layout rules described above. Note that the puzzle
     * represented by grid does not have to be solvable.
     */
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

    /**
     * Helper method for sudoku2 method
     * @param check a given row of 9 characters from the sudoku board
     * @return True if there are no repeating numbers, false if there are
     */
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

    /**
     * A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence
     * between letters and digits, such that the given arithmetic equation consisting of letters
     * holds true when the letters are converted to digits.
     *
     * You have an array of strings crypt, the cryptarithm, and an an array containing the mapping
     * of letters and digits, solution. The array crypt will contain three non-empty strings that
     * follow the structure: [word1, word2, word3], which should be interpreted as the
     * word1 + word2 = word3 cryptarithm.
     *
     * If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits
     * using the mapping in solution, becomes a valid arithmetic equation containing no numbers
     * with leading zeroes, the answer is true. If it does not become a valid arithmetic solution,
     * the answer is false.
     *
     * Example
     *
     * For crypt = ["SEND", "MORE", "MONEY"] and
     *
     * solution = [['O', '0'],
     * ['M', '1'],
     * ['Y', '2'],
     * ['E', '5'],
     * ['N', '6'],
     * ['D', '7'],
     * ['R', '8'],
     * ['S', '9']]
     * the output should be
     * isCryptSolution(crypt, solution) = true.
     *
     * When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in crypt, you get
     * 9567 + 1085 = 10652 which is correct and a valid arithmetic equation.
     *
     * For crypt = ["TEN", "TWO", "ONE"] and
     *
     * solution = [['O', '1'],
     * ['T', '0'],
     * ['W', '9'],
     * ['E', '5'],
     * ['N', '4']]
     * the output should be
     * isCryptSolution(crypt, solution) = false.
     *
     * Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes, meaning that this is
     * not a valid solution.
     *
     * Input/Output
     *
     * [time limit] 3000ms (java)
     * [input] array.string crypt
     *
     * An array of three non-empty strings containing only uppercase English letters.
     *
     * Guaranteed constraints:
     * crypt.length = 3,
     * 1 ≤ crypt[i].length ≤ 14.
     *
     * [input] array.array.char solution
     *
     * An array consisting of pairs of characters that represent the correspondence between letters
     * and numbers in the cryptarithm. The first character in the pair is an uppercase English
     * letter, and the second one is a digit in the range from 0 to 9.
     *
     * Guaranteed constraints:
     * solution[i].length = 2,
     * 'A' ≤ solution[i][0] ≤ 'Z',
     * '0' ≤ solution[i][1] ≤ '9',
     * solution[i][0] ≠ solution[j][0], i ≠ j,
     * solution[i][1] ≠ solution[j][1], i ≠ j.
     *
     * It is guaranteed that solution only contains entries for the letters present in crypt and
     * that different letters have different values.
     *
     * [output] boolean
     *
     * Return true if the solution represents the correct solution to the cryptarithm crypt,
     * otherwise return false.
     */
    boolean isCryptSolution(String[] crypt, char[][] solution) {
        String wordOne, wordTwo, wordThree;
        HashMap<Character, Character> map = new HashMap<>();

        // Convert solution into a map for fast access
        for(int i = 0; i < solution.length; i++) {
                map.put(solution[i][0], solution[i][1]);
        }

        // Do the arithmetic for the crypt words
        wordOne = wordValue(crypt[0], map);
        if(wordOne.length() > 1 && wordOne.startsWith("0")) return false;
        wordTwo = wordValue(crypt[1], map);
        if(wordTwo.length() > 1 && wordTwo.startsWith("0")) return false;
        wordThree = wordValue(crypt[2], map);
        if(wordThree.length() > 1 && wordThree.startsWith("0")) return false;

        return Long.parseLong(wordOne) + Long.parseLong(wordTwo) == Long.parseLong(wordThree);
    }

    String wordValue(String word, Map table) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
           sb.append(table.get(word.charAt(i)));
        }
        return sb.toString();
    }

    boolean isCryptSolution2(String[] crypt, char[][] solution) {
        for(char[] arr : solution) {
            for(int i = 0; i < crypt.length; i++) {
                crypt[i] = crypt[i].replace(arr[0], arr[1]);
            }
        }

        for(int i = 0; i < crypt.length; i++) {
            if(!crypt[i].equals("0") && crypt[i].startsWith("0")) return false;
        }

        return Long.parseLong(crypt[0]) + Long.parseLong(crypt[1]) == Long.parseLong(crypt[2]);
    }

    /**
     * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the
     * number of elements in the list, since this is what you'll be asked to do during an interview.
     * Given a singly linked list of integers l and an integer k, remove all elements from list l
     * that have a value equal to k.
     *
     * Example
     *
     * For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
     * removeKFromList(l, k) = [1, 2, 4, 5];
     *
     * For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
     * removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
     * @param l
     * @param k
     * @return
     */
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        // No Node Exists
        if(l == null) return null;

        ListNode<Integer> head = l; // Store the head to return

        do {
            // Check for the next node
            if(l.next != null) {
                // If the next node after is the K value
                if(l.next.value.equals(k)) {
                    // Check for a node following
                    if(l.next.next != null) {
                        // Move the reference pointer from the next to the one after
                        l.next = l.next.next;
                    } else {
                        // If there isn't a node past next, simply remove the pointer to next
                        l.next = null; // End the line if the next node matches and is the end
                    }
                } else {
                    // The next node DOES NOT match the value and can be moved into
                    l = l.next;
                }
            }
        } while (l.next != null); // Keep going until you reach the end of the list

        // At this point, the only possible K value can reside in the head. Check the head
        if(head.value.equals(k)) {
            // If the head has a next, simply move the head reference to the next node
            if(head.next != null) {
                head = head.next;
            } else {
                // The K value head does NOT have a next, so simply return null
                return null;
            }
        }

        return head;
    }

    /**
     * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the
     * number of elements in l, since this is what you'll be asked to do during an interview.
     *
     * Given a singly linked list of integers, determine whether or not it's a palindrome.
     *
     * Example
     *
     * For l = [0, 1, 0], the output should be
     * isListPalindrome(l) = true;
     * For l = [1, 2, 2, 3], the output should be
     * isListPalindrome(l) = false.
     *
     * Input/Output
     * [time limit] 3000ms (java)
     * [input] linkedlist.integer l
     * A singly linked list of integers.
     *
     * Guaranteed constraints:
     * 0 ≤ list size ≤ 5 · 105,
     * -109 ≤ element value ≤ 109.
     *
     * [output] boolean
     *
     * Return true if l is a palindrome, otherwise return false.
     */
    boolean isListPalindrome(ListNode<Integer> l) {

        if(l == null) return true;

        ArrayList<Integer> values = new ArrayList<>();

        values.add(l.value);

        if(l.next != null) {
            do {
                l = l.next;
                values.add(l.value);
            } while(l.next != null);
        }

        for(int i = 0; i < values.size() / 2; i++) {
            if(!values.get(i).equals(values.get(values.size() - 1 - i))) return false;
        }

        return true;
    }

    /**
     * You're given 2 huge integers represented by linked lists. Each linked list element is a
     * number from 0 to 9999 that represents a number with exactly 4 digits. The represented number
     * might have leading zeros. Your task is to add up these huge integers and return the result
     * in the same format.
     *
     * Example
     *
     * For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
     * addTwoHugeNumbers(a, b) = [9876, 5434, 0].
     *
     * Explanation: 987654321999 + 18001 = 987654340000.
     *
     * For a = [123, 4, 5] and b = [100, 100, 100], the output should be
     * addTwoHugeNumbers(a, b) = [223, 104, 105].
     *
     * Explanation: 12300040005 + 10001000100 = 22301040105.
     *
     * Input/Output
     *
     * [time limit] 3000ms (java)
     * [input] linkedlist.integer a
     * The first number, without its leading zeros.
     *
     * Guaranteed constraints:
     * 0 ≤ a size ≤ 104,
     * 0 ≤ element value ≤ 9999.
     *
     * [input] linkedlist.integer b
     *
     * The second number, without its leading zeros.
     *
     * Guaranteed constraints:
     * 0 ≤ b size ≤ 104,
     * 0 ≤ element value ≤ 9999.
     *
     * [output] linkedlist.integer
     *
     * The result of adding a and b together, returned without leading zeros in the same format.
     * @param a linkedlist.integer a
     * @param b linkedlist.integer b
     * @return linkedlist.integer
     */
    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        Long sum;
        BigInteger bigNum, bigNum2;
        StringBuilder sumString = new StringBuilder();
        StringBuilder firstNum, secondNum;

        firstNum = new StringBuilder();
        secondNum = new StringBuilder();

        int maxValue = 0;

        if(a != null) {
            do {
                maxValue = a.value.toString().length() > maxValue ? a.value.toString().length() : maxValue;
                for(int i = 0; i < 4 - a.value.toString().length(); i++) firstNum.append("0");
                firstNum.append(a.value);
                a = a.next;
            } while(a != null);
        }

        if(b != null) {
            do {
                maxValue = b.value.toString().length() > maxValue ? b.value.toString().length() : maxValue;
                for(int i = 0; i < 4 - b.value.toString().length(); i++) secondNum.append("0");
                secondNum.append(b.value);
                b = b.next;
            } while(b != null);
        }

        bigNum = new BigInteger(firstNum.toString());
        bigNum2 = new BigInteger(secondNum.toString());

        BigInteger bigSum = bigNum.add(bigNum2);
        // sum = Long.parseLong(firstNum.toString()) + Long.parseLong(secondNum.toString());

        if(bigSum.toString().length() % 4 != 0) {
            for(int i = 0; i < 4 - bigSum.toString().length() % 4; i++) {
                sumString.append("0");
            }
        }
        sumString.append(bigSum.toString());
        int stringLen = sumString.length();

        int checker = 0;

        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0; i < stringLen; i+=4) {
            String seq = sumString.substring(i, i + 4);
            int num = Integer.parseInt(seq);
            // Check for a series with a leading 0 and not a value of 0

                // Add the value to the array
                values.add(num);
                // Check if the next series is not a multiple of max and add the final values if you're at the end
                if(stringLen % (maxValue - checker) != 0 && i + maxValue * 2 > stringLen) {
                    values.add(Integer.parseInt(sumString.substring(i+4, sumString.length())));
                    break;

            }
        }

        ListNode<Integer> sumNodeHead = new ListNode<>(values.get(0));
        ListNode<Integer> currentNode = sumNodeHead;

        for(int i = 1; i < values.size(); i++) {
            currentNode.next = new ListNode<>(values.get(i));
            currentNode = currentNode.next;
        }

        printNodes(sumNodeHead);
        return sumNodeHead;

    }

    void printNodes(ListNode<Integer> node) {
        System.out.println("");
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    ListNode<Integer> addTwoHugeNumbers2(ListNode<Integer> a, ListNode<Integer> b) {

        ListNode<Integer> headA = a, prev = null, headB = b, returnHead = null;

        while(headA!=null){
            ListNode<Integer> next = headA.next;
            headA.next = prev;
            prev = headA;
            headA = next;
        }

        headA = prev;
        prev = null;

        while(headB != null){
            ListNode<Integer> next = headB.next;
            headB.next = prev;
            prev = headB;
            headB = next;
        }
        headB = prev;

        int carry = 0;
        while(headA != null && headB != null){
            int sum = headA.value + headB.value + carry;
            headA = headA.next;
            headB = headB.next;

            carry = sum / 10000;
            sum = sum % 10000;

            ListNode<Integer> newNode = new ListNode<Integer>(sum);
            newNode.next = returnHead;
            returnHead = newNode;
        }

        while(headA != null){
            int sum = headA.value +  carry;
            headA = headA.next;

            carry = sum / 10000;
            sum = sum % 10000;
            ListNode<Integer> newNode = new ListNode<Integer>(sum);

            newNode.next = returnHead;
            returnHead = newNode;
        }

        while(headB != null){

            int sum = headB.value + carry;
            headB = headB.next;

            carry = sum / 10000;
            sum = sum % 10000;

            ListNode<Integer> newNode = new ListNode<Integer>(sum);
            newNode.next = returnHead;
            returnHead = newNode;
        }
        if(carry != 0){
            ListNode<Integer> newNode = new ListNode<Integer>(carry);
            newNode.next = returnHead;
            returnHead = newNode;
        }

        return returnHead;

    }

    /**
     * Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what
     * you will be asked to accomplish in an interview.
     *
     * Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In
     * other words, return a singly linked list, also sorted in non-decreasing order, that contains
     * the elements from both original lists.
     *
     * Example
     *
     * For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
     * mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
     * For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
     * mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
     *
     * Input/Output

     [time limit] 3000ms (java)
     [input] linkedlist.integer l1

     A singly linked list of integers.

     Guaranteed constraints:
     0 ≤ list size ≤ 104,
     -109 ≤ element value ≤ 109.

     [input] linkedlist.integer l2

     A singly linked list of integers.

     Guaranteed constraints:
     0 ≤ list size ≤ 104,
     -109 ≤ element value ≤ 109.

     [output] linkedlist.integer

     A list that contains elements from both l1 and l2, sorted in non-decreasing order.
     */
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {

        // Check for an empty list and return the other one
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // Create a starting Node based on the lower value of the first nodes
        ListNode<Integer> head = l1.value < l2.value ? l1 : l2;
        if(l1.value > l2.value) l2 = l2.next;
        else l1 = l1.next;

        ListNode<Integer> current = head;

        while(l1 != null && l2 != null) {
            ListNode<Integer> node = l1.value < l2.value ? l1 : l2;
            current.next = node;
            current = node;
            if(l1.value < l2.value) l1 = l1.next;
            else l2 = l2.next;
        }

        if(l1 != null) current.next = l1;
        if(l2 != null) current.next = l2;

        // return the head of the list
        printNodes(head);
        return head;
    }
}
