class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n]; // queens[row] = coloana reginei de pe rândul row
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row - col + n
        boolean[] diag2 = new boolean[2 * n]; // row + col

        backtrack(0, n, queens, cols, diag1, diag2);
        return ans;
    }

    private void backtrack(int row, int n, int[] queens,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            ans.add(build(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row - col + n] || diag2[row + col]) continue;

            queens[row] = col;
            cols[col] = true;
            diag1[row - col + n] = true;
            diag2[row + col] = true;

            backtrack(row + 1, n, queens, cols, diag1, diag2);

            cols[col] = false;
            diag1[row - col + n] = false;
            diag2[row + col] = false;
        }
    }

    private List<String> build(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[queens[row]] = 'Q';
            board.add(new String(line));
        }
        return board;
    }
}