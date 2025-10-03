package neetCode150.stack;

import java.util.Stack;


public class EvaluateReversePolishNotation {
    /** <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/">...</a>
     Example : Let's take the expression "3 + 4". In RPN, this would be written as "3 4 +".

     Here's how it's evaluated:

     1. Push 3 onto the stack.
     2. Push 4 onto the stack.
     3. Encounter the '+' operator.
     4. Pop the top two numbers from the stack (4 and 3).
     5. Perform the addition (3 + 4 = 7).
     6. Push the result (7) back onto the stack.

     The final result on the stack is 7.
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // check if token is an operand and not a number
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop(); // in the end the final element in the stack will be the result
    }

    public static void main(String[] args) {
        /**
        Input: tokens = ["2","1","+","3","*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9
        */
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens)); // 9
    }
}
