package neetCode150.stack;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/generate-parentheses/description/
 Given n pairs of parentheses, write a function to generate all combinations of "well-formed parentheses".

 Example 1:
 Input: n = 1
 Output: ["()"]

 Example 2:
 Input: n = 2
 Output: ["(())", "()()"]

 Example 3:
 Input: n = 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]

*/
public class GenerateParentheses {
    // Todo : Time and space complexity analysis

    /*  Recursive approach
    1. Only Add open parenthesis if open < n
    2. Only add a closing parenthesis if closed < open
    3. Valid IFF open == closed == n
    * */
    public static void generateParenthesisUsingRecursion(int openCount, int closedCount, int n,
                                                         List<String> result, StringBuilder stack) {
        if (openCount == closedCount && openCount == n) {
            result.add(stack.toString());
            return;
        }

        if (openCount < n) {
            stack.append('(');
            generateParenthesisUsingRecursion(openCount + 1, closedCount, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedCount < openCount) {
            stack.append(')');
            generateParenthesisUsingRecursion(openCount, closedCount + 1, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        int n = 3;
        generateParenthesisUsingRecursion(0, 0, n, result, stack);
        System.out.println(result);
    }
}
