package neetCode150.trees;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">LeetCode Problem: Lowest Common Ancestor of a Binary Search Tree</a>
 Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    /**
     * Intuition :
     * In a Binary Search Tree, the values are ordered: left subtree  <  root  <  right subtree
     * So for any two nodes p and q:
     * a. If both p and q are smaller than the current root → LCA is in the left subtree.
     * b. If both p and q are greater than the current root → LCA is in the right subtree.
     * c. Otherwise (they split around the root) → the current root is the LCA.
     * Pattern Name : Binary Search on a BST (a.k.a. Directed Tree Traversal Using BST Ordering)
     *
     * Time Complexity : O(h) where h is height of tree.
     * Space Complexity : O(1) , (iterative approach).
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // We walk down the tree using BST property
        while (root != null) {

            // Case 1: both nodes are smaller → go to left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // Case 2: both nodes are larger → go to right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Case 3: they split → current node is the LCA
            else {
                return root;
            }
        }

        return null; // safety return (should not happen for valid inputs)
    }
}
