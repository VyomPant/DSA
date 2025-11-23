package neetCode150.trees;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">LeetCode Problem: Diameter  of Binary Tree</a>
 * Given the root of a binary tree,  return the length of the diameter of the tree
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root
 *
 */
public class DiameterOfBinaryTree {

    // diameter =  maximum among the sums of the left height and right height of the nodes in the tree

    /*
     * Approach 1 : Brute Force DFS, we compute height for each node and diameter for each node
     * Time complexity: O(n^2) ,
     * Space complexity: O(h) for recursion stack where h is height of binary tree.
     *      - Best Case : O(log n) for balanced tree
     *      - Worst Case : O(n) for skewed tree
     * */
    public int diameterOfBinaryTree(TreeNode root) {
    /*
        For each node: Compute height(left) and Compute height(right)
        diameter at this node = leftHeight + rightHeight
        Max across all nodes ,BUT calculating height for each node costs O(n), and there are n nodes → O(n²) total.
       */
        if (root == null) {
            return 0;
        }

        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight + rightHeight,
                Math.max(leftDia, rightDia));

/*        One line alternative (same logic)
        int currDiameter = height(root.left) + height(root.right);
        return Math.max(currDiameter, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));*/
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /*
     * Approach 2 : Optimal DFS, we can compute the diameter as we calculate the height of the tree
     * Time complexity: O(n) ,
     * Space complexity: O(h) for recursion stack where h is height of binary tree.
     *      - Best Case : O(log n) for balanced tree
     *      - Worst Case : O(n) for skewed tree
     * */
    private int diameter = 0;  // global max diameter
    public int diameterOfBinaryTreeOptimal(TreeNode root) {
        heightOptimal(root);
        return diameter;
    }

    /* We optimise our height function , while computing height, we can also compute diameter.
       So height() returns: height of subtree, while updating a global diameter variable
    * */
    private int heightOptimal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightOptimal(node.left);
        int rightHeight = heightOptimal(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
