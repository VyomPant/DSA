package neetCode150.trees;

/**
 * <a href="https://leetcode.com/problems/same-tree/">LeetCode Problem: Same Tree</a>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {

    /**Intuition:
     * Two binary trees are the same if:
     * 1.Their root values are equal, and
     * 2.Their left subtrees are the same, and
     * 3.Their right subtrees are the same.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h) , where h is height of binary tree.
     *  - Best Case : O(log n) for balanced tree
     *  - Worst Case : O(n) for skewed tree
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: Both nodes are null → this part matches
        if (p == null && q == null) {
            return true;
        }

        // Case 2: One is null → mismatch
        if (p == null || q == null) {
            return false;
        }

        // Case 3: Values differ → mismatch
        if (p.val != q.val) {
            return false;
        }

        // Case 4: Values match → recursively check left + right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
