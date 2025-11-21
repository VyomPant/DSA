package neetCode150.trees;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/description/">LeetCode Problem: Invert Binary Tree</a>
 * <p>
 * <a href="src/neetCode150/trees/notes/InvertBinaryTree.MD">📝 Detailed Solution Notes</a>
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Before inversion:
 *       4
 *     /   \
 *    2     7
 *   / \   / \
 *  1  3  6   9
 * <p>
 * After inversion:
 *       4
 *     /   \
 *    7     2
 *   / \   / \
 *  9  6  3   1
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class InvertBinaryTree {

    /*
    Intuition:  At every node swap(left, right)
    TIP (Interview):

    This is the same approach used for problems like:

    Mirror a tree

    Symmetric tree check

    Swapping child pointers

    Postorder-based structural modifications
    */


    /* Approach 1 : DFS recursive
     * Time complexity: O(n)
     * Space complexity: O(n) for recursion stack.
     * */
    public TreeNode invertTree(TreeNode root) {
        // Base case: if node is null, nothing to invert
        if (root == null) return null;

        // STEP 1: Swap the children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // STEP 2: Recursively invert left subtree
        invertTree(root.left);

        // STEP 3: Recursively invert right subtree
        invertTree(root.right);

        // Finally return root so parent nodes can link correctly
        return root;
    }

    /* Approach 2 : BFS (level order)
     * Time complexity: O(n)
     * Space complexity: O(n) .
     * */
    public TreeNode invertTreeBFS(TreeNode root) {
        /*
        BFS means:
        1. Visit nodes level by level, left to right.
        2. At each node you:
            a. Swap children
            b. Push children to queue
        3. So that swapping continues in level order.*/

        // Edge case: empty tree
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start BFS with root

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();  // Get next node in BFS order

            // Swap children of this node
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add children to queue to process later
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }


    /* Approach 3 : Iterative DFS using stack
     * Time complexity: O(n)
     * Space complexity: O(n) .
     * */
    public TreeNode invertTreeIterativeDFS(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();  // DFS: take top of stack

            // Swap children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Push children to stack (DFS)
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return root;
    }

}
