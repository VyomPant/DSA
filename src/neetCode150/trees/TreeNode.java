package neetCode150.trees;

// Node of a Binary Tree
public class TreeNode {
    int val;           // value stored at this node
    TreeNode left;     // reference to left child (may be null)
    TreeNode right;    // reference to right child (may be null)

    TreeNode() {}
    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

