package neetCode150.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/
public class MinStack {
    /* Using two stacks
     Time complexity:O(1) for all operations
     Space complexity:O(n) for the extra min stack
     */
    private Stack<Integer> stack; //original stack
    private Stack<Integer> minStack; // it's top element stores minimum element corresponding to the original stack

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push to minStack only if it's the smallest so far
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }

    /*
        Using One stack
        Time complexity:O(1) for all operations
        Space complexity:O(1) , if we exclude the size of the stack not using any extra data structure
        */
    class MinStackOptimised {
        private Stack<long[]> stack;

        public MinStackOptimised() {
            stack = new Stack<>();
        }

        public void push(int val) {
            // If stack is empty, the min is the value itself
            if (stack.isEmpty()) {
                stack.push(new long[]{val, val});
            } else {
                // Store the value and the minimum so far
                long minSoFar = Math.min(val, stack.peek()[1]);
                stack.push(new long[]{val, minSoFar});
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int top() {
            return (int) stack.peek()[0];
        }

        public int getMin() {
            return (int) stack.peek()[1];
        }
    }
    /*
 How it Works
Stack Operation           Stored Pair (val, minSoFar)     minStack Equivalent
push(5)	                   (5, 5)	                           5
push(3)	                   (3, 3)	                           3
push(7)	                   (7, 3)	                           3
pop()	                   Remove (7, 3)	                   3
getMin()	               Returns 3	                       3
The first value in the pair is the actual stack element.
The second value is the minimum at that point.
    * */

}
