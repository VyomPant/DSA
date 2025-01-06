package neetCode150.arraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*- Time complexity:O(n^2)
   Space complexity:O(n^2)
   https://leetcode.com/problems/valid-sudoku/
*/
public class ValidSoduku {
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columnMap = new HashMap<>(); // Map to identify unique values in a column, Key->columnNumber, value->set of elements(1-9) in present in that column
        Map<Integer, Set<Character>> rowMap = new HashMap<>(); // Map to identify unique values in a rows, Key->rowNumber, value->set of elements(1-9) in present in that row
        Map<String, Set<Character>> subSquareMap = new HashMap<>(); // Map to identify unique values in a subSquare, Key->subSquareNumber(which is computed by using the formula  (row / 3) * 3 + (col / 3) ), value->set of elements(1-9) in present in that column

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue; // empty entry

                /*We can find the index of each subSquare by the equation (row / 3) * 3 + (col / 3).
                Then we use hash set for O(1) lookups while inserting the number into its row, column and square it belongs to.
                We use separate hash maps for rows, columns, and squares.
                 */
                String subSquareKey = (r / 3) + "," + (c / 3);
                if (rowMap.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) || // if row contains current element
                        columnMap.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) || // if column contains current element
                        subSquareMap.computeIfAbsent(subSquareKey, k -> new HashSet<>()).contains(board[r][c])) { // if subSquare contains current element
                    return false;
                }
                //Add this element to all maps to mark it's presence in particular row,column and subSquare
                rowMap.get(r).add(board[r][c]);
                columnMap.get(c).add(board[r][c]);
                subSquareMap.get(subSquareKey).add(board[r][c]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] validBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] invalidBoard = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(validBoard));
        System.out.println(isValidSudoku(invalidBoard));
    }
}
