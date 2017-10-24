class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] solution = new int[2];

        // solution = sol.twoSum(arr, target);
        // for(int i : solution) System.out.print(i + " ");
        //        sol.judgeCircle("LL");

//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//
//        n1.left = n2;
//        n2.left = n3;
//
//        TreeNode m1 = new TreeNode(1);
//        TreeNode m2 = new TreeNode(2);
//        TreeNode m3 = new TreeNode(3);
//
//        m1.right = m2;
//        m2.right = m3;
//
//        TreeNode result = sol.mergeTrees(n1, m1);

        char[][] sudoku = {{'.','9','.','.','4','.','.','.','.'},
                {'1','.','.','.','.','.','6','.','.'},
                {'.','.','3','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','7','.','.','.','.','.'},
                {'3','.','.','.','5','.','.','.','.'},
                {'.','.','7','.','.','4','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','7','.','.','.','.'}};

        sol.sudoku2(sudoku);
    }
}
