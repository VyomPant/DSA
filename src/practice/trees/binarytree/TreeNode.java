package practice.trees.binarytree;

// Node of a Binary Tree
class TreeNode {
    int val;           // value stored at this node
    TreeNode left;     // reference to left child (may be null)
    TreeNode right;    // reference to right child (may be null)

    // Constructor: create a node with a value and null children
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}