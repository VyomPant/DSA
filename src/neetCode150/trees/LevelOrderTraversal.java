package neetCode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">LeetCode Problem: Level Order Traversal</a>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class LevelOrderTraversal {
    /**
     * Intuition
     * We need to visit nodes level by level, left to right.
     * This means we must process nodes in the order they appear by depth.
     * A queue is perfect for this because it preserves FIFO order → the node added first (higher level) is processed first.
     * So we perform Breadth-First Search (BFS) and record all nodes belonging to the same level together.
     * Time Complexity : O(n) (every node is visted once )
     * Space Complexity : O(n) (Queue holds up to one entire level (worst case ~N/2) )
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();  // Number of nodes at current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // Pop from queue
                level.add(node.val);      // Add value to current level

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            result.add(level);  // Add completed level to result
        }

        return result;
    }
}
