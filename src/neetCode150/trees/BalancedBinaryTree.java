package neetCode150.trees;

/**
 * <a href="Given a binary tree, determine if it is height-balanced.">LeetCode Problem: Balanced Binary Tree</a>
 * Given a binary tree, determine if it is height-balanced.
 * A height balanced binary tree is one where the depth of the two subtrees of every node never differs by more than one.
 */

public class BalancedBinaryTree {
    /**
     * Approach 1 : Brute Force DFS , we traverse every node and check whether the tree rooted at each node is balanced
    * by computing the heights of its left and right subtrees
    * Time complexity: O(n^2) ,
    * Space complexity: O(h) for recursion stack where h is height of binary tree.
    *      - Best Case : O(log n) for balanced tree
    *      - Worst Case : O(n) for skewed tree
    * */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check current node
        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        // Recursively check left & right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Approach 2 : Optimal DFS
    1. Compute height of children ,At the same time, check balance
    2. Return height to parent
    3. If any subtree is unbalanced → propagate failure upward (return -1 for that)

    * Time complexity: O(n) ,
    * Space complexity: O(h) for recursion stack where h is height of binary tree.
    *      - Best Case : O(log n) for balanced tree
    *      - Worst Case : O(n) for skewed tree
    * */
    public boolean isBalancedOptimal(TreeNode root) {
        return checkIsBalanced(root) != -1;
    }

    /**
     * checkIsBalanced(node) returns the HEIGHT of the subtree rooted at `node`
     * OR returns -1 if the subtree is NOT height-balanced.
     */
    private int checkIsBalanced(TreeNode node) {
        if (node == null) return 0;

        int left = checkIsBalanced(node.left);
        if (left == -1) return -1;  // left subtree unbalanced

        int right = checkIsBalanced(node.right);
        if (right == -1) return -1; // right subtree unbalanced

        // Check if current node is balanced
        if (Math.abs(left - right) > 1) return -1;

        // Return height of subtree
        return 1 + Math.max(left, right);
    }
}