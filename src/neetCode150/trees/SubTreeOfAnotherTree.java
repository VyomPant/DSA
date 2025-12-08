package neetCode150.trees;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">LeetCode Problem: Subtree of Another Tree</a>
 Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class SubTreeOfAnotherTree {

    /**
     * Intuition :
     * To determine if subRoot is a subtree of root, we do two things:
     * 1 Traverse every node in root
     * 2 Because subRoot could start anywhere.
     * 3 At each node, check if the current subtree is identical to subRoot
     * So the problem breaks into: Traversal + Same-Tree check
     *
     * Time Complexity: O(m*n)
     * Space Complexity: O(m+n) , where m is number of nodes in subRoot and n  is number of nodes in Root.
     * */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If main tree is empty, no subtree can exist
        if (root == null) return false;

        // If current nodes match AND the subtrees are identical → found subtree
        if (isSame(root, subRoot)) return true;

        // Otherwise, keep searching left & right
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper to check if two trees are identical
    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
