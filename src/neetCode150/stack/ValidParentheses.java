package neetCode150.stack;

import java.util.Stack;

/* https://leetcode.com/problems/valid-parentheses/description/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // If it's a closing bracket, check if it matches the top of the stack
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                char top = stack.pop(); // pop top and check if the type of opening bracket matches with the closing bracket
                if (!isMatchingPair(top, ch)) {
                    return false; // Mismatched pair
                }
            }
        }
        // If stack is empty at the end, all brackets were balanced
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char openingBracket, char closingBracket) {
        return (openingBracket == '(' && closingBracket == ')') ||
                (openingBracket == '{' && closingBracket == '}') ||
                (openingBracket == '[' && closingBracket == ']');
    }

    public static void main(String[] args) {
        String expression = "{[(2+3)*(5+2)]}";
        System.out.println("Is the expression balanced? " + isValid(expression));
    }
}
