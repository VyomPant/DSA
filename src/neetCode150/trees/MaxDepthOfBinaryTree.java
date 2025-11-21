package neetCode150.trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">LeetCode Problem: Maximum Depth of Binary Tree</a>
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaxDepthOfBinaryTree {

    /* Approach 1 : DFS recursive
     * Time complexity: O(n)
     * Space complexity: O(h) for recursion stack where h is height of binary tree.
     *      - Best Case : O(log n) for balanced tree
     *      - Worst Case : O(n) for skewed tree
     * */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /* Approach 2 : BFS (level order)
     * Time complexity: O(n)
     * Space complexity: O(w) for queue where w is width of binary tree.
     *      - Best Case : O(log n) for balanced tree
     *      - Worst Case : O(n) for skewed tree
     * */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // Approach 3 : iterative dfs
    /*
    Intuition:
    1. Use stack to simulate recursion
    2. Push root to stack
    3. While stack is not empty:
        a. Pop node from stack
        b. Increment depth
        c. Push left and right children to stack
    Time complexity: O(n)
    Space complexity: O(h) for stack where h is height of binary tree.
    */
    public int maxDepthIterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            depth++;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return depth;
    }

}
