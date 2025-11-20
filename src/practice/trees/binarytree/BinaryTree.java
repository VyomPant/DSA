package practice.trees.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Simple Binary Tree implementation (not a BST).
 * - TreeNode: node structure
 * - BinaryTree: helper methods to build and traverse the tree
 * This implementation inserts nodes level-by-level (like building a complete tree).
 *
 * Further reading: <a href="https://www.geeksforgeeks.org/dsa/tree-data-structure/">...</a>
 */
class BinaryTree {

    // Root of the tree. If root is null, tree is empty.
    TreeNode root;

    /**
     * Insert a value into the tree using level-order insertion.
     * This does NOT keep the tree sorted; it fills the tree left-to-right at each level.
     *
     * Example insertion order: 1,2,3,4,5
     * Results in:
     *         1
     *       /   \
     *      2     3
     *     / \
     *    4   5
     */
    public void insert(int val) {
        TreeNode newNode = new TreeNode(val); // create new node with specified value

        // If tree is empty, new node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        // Use a queue to do level-order traversal until we find a spot.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // get next node from queue

            // If left child is missing, insert there and return
            if (node.left == null) {
                node.left = newNode;
                return;
            } else {
                // else push left child to queue to inspect later
                queue.offer(node.left);
            }

            // If right child is missing, insert there and return
            if (node.right == null) {
                node.right = newNode;
                return;
            } else {
                // else push right child to queue to inspect later
                queue.offer(node.right);
            }
        }
    }

    // =============================
    // DFS Traversals  (recursive)
    // Preorder: Root -> Left -> Right
    // Inorder : Left -> Root -> Right
    // Postorder: Left -> Right -> Root
    // =============================

    // Preorder traversal: process node, then left subtree, then right subtree
    // print traversals in console
    public void preorder(TreeNode node) {
        if (node == null) return;          // base case: nothing to do
        System.out.print(node.val + " ");  // visit / process current node
        preorder(node.left);               // recursive call on left child
        preorder(node.right);              // recursive call on right child
    }

    // return the traversals result in a list useful in LeetCode/Interview problems
    public List<Integer> preorderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);           // Root
        preorderHelper(node.left, result);  // Left
        preorderHelper(node.right, result); // Right
    }


    // Inorder traversal: left subtree, then node, then right subtree
    // print traversals in console
    public void inorder(TreeNode node) {
        if (node == null) return;          // base case
        inorder(node.left);                // process left subtree
        System.out.print(node.val + " ");  // then current node
        inorder(node.right);               // then right subtree
    }

    // return the traversals result in a list useful in LeetCode/Interview problems
    public List<Integer> inorderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inorderHelper(node.left, result);   // Left
        result.add(node.val);               // Root
        inorderHelper(node.right, result);  // Right
    }


    // Postorder traversal: left subtree, right subtree, then node
    // print traversals in console
    public void postorder(TreeNode node) {
        if (node == null) return;          // base case
        postorder(node.left);              // left
        postorder(node.right);             // right
        System.out.print(node.val + " ");  // then node
    }

    // return the traversals result in a list useful in LeetCode/Interview problems
    public List<Integer> postorderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postorderHelper(node.left, result);   // Left
        postorderHelper(node.right, result);  // Right
        result.add(node.val);                 // Root
    }


    // =============================
    // BFS Traversal (Level Order) - iterative using a queue
    // =============================

    // print traversals in console
    public void levelOrder(TreeNode root) {
        if (root == null) return;          // nothing to print for empty tree

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);                 // start with root

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();  // take front of queue
            System.out.print(node.val + " "); // visit current node

            // enqueue children so their values get printed later (left first, then right)
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    // return the traversals result in a list useful in LeetCode/Interview problems
    public List<Integer> levelOrderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return result;
    }

}