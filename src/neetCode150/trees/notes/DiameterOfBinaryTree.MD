# Diameter of Binary Tree

## Problem Statement
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

**Example 1:**
```
      1
     / \
    2   3
   / \
  4   5
```
**Output:** 3  
**Explanation:** The longest path is [4,2,1,3] or [5,2,1,3] with length 3.

## Approaches

### 1. Naive Recursive Approach (O(n²))
**Intuition:**
- For each node, calculate the height of left and right subtrees
- The diameter through the current node is the sum of left and right heights
- The maximum of all such values is our answer

**Code:**
```java
public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    
    // Calculate diameter through current node
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    int currentDiameter = leftHeight + rightHeight;
    
    // Get diameters of left and right subtrees
    int leftDiameter = diameterOfBinaryTree(root.left);
    int rightDiameter = diameterOfBinaryTree(root.right);
    
    // Return max of current diameter and diameters from subtrees
    return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
}

private int height(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.left), height(node.right));
}
```

**Time Complexity:** O(n²) - We're calculating height for each node, and for each height calculation, we visit all nodes in that subtree.
**Space Complexity:** O(h) - Where h is the height of the tree (recursion stack).

### 2. Optimized DFS (O(n))
**Intuition:**
- Calculate height and diameter in a single pass
- Use a class variable to keep track of maximum diameter found so far
- For each node, calculate the diameter and update the maximum if needed

**Code:**
```java
class Solution {
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
```

**Time Complexity:** O(n) - Each node is visited exactly once
**Space Complexity:** O(h) - Where h is the height of the tree (recursion stack)

## Edge Cases
1. Empty tree (root is null)
2. Single node tree
3. Skewed tree (linked list like structure)
4. Balanced tree
5. Tree with negative values (if values matter, though in this problem they don't)

## Key Insights
- The diameter doesn't necessarily pass through the root
- The longest path between any two nodes in a tree is equal to the maximum of:
  - The diameter of the left subtree
  - The diameter of the right subtree
  - The longest path that goes through the current node (left height + right height)

## Follow-up Questions
1. What if we need to return the actual path instead of just the length?
2. How would you solve this iteratively?
3. Can you solve it with O(1) space (without recursion)?

## Similar Problems
1. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
2. [Longest Univalue Path](https://leetcode.com/problems/longest-univalue-path/)
3. [Maximum Path Sum in a Binary Tree](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

## Practice
Try solving these variations:
1. Find the diameter of an N-ary tree
2. Find the diameter of a graph
3. Find all paths with maximum diameter in a tree