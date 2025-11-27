# Balanced Binary Tree

## Problem Statement
Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is defined as:
- A binary tree in which the left and right subtrees of every node differ in height by no more than 1.

**Example 1:**
```
Input: root = [3,9,20,null,null,15,7]
Output: true
```

**Example 2:**
```
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
```

**Constraints:**
- The number of nodes in the tree is in the range [0, 5000].
- -10^4 <= Node.val <= 10^4

[LeetCode Problem Link](https://leetcode.com/problems/balanced-binary-tree/)

## Approaches

### Approach 1: Brute Force DFS (Time: O(n²), Space: O(h))
**Intuition:**
- Traverse every node and check if the tree rooted at each node is balanced by computing the heights of its left and right subtrees.
- If the height difference is more than 1, the tree is not balanced.

**Code:**
```java
public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    // Check current node
    if (Math.abs(leftHeight - rightHeight) > 1) return false;

    // Recursively check left & right subtrees
    return isBalanced(root.left) && isBalanced(root.right);
}

private int height(TreeNode node) {
    if (node == null) {
        return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
}
```

### Approach 2: Optimal DFS (Time: O(n), Space: O(h))
**Intuition:**
- Compute the height of children while simultaneously checking balance.
- Propagate the height to the parent.
- If any subtree is unbalanced, propagate the failure upward by returning -1.

**Code:**
```java
public boolean isBalancedOptimal(TreeNode root) {
    return checkHeight(root) != -1;
}

private int checkHeight(TreeNode node) {
    if (node == null) {
        return 0;
    }
    
    int leftHeight = checkHeight(node.left);
    if (leftHeight == -1) return -1;
    
    int rightHeight = checkHeight(node.right);
    if (rightHeight == -1) return -1;
    
    if (Math.abs(leftHeight - rightHeight) > 1) {
        return -1;
    }
    
    return 1 + Math.max(leftHeight, rightHeight);
}
```

**Key Differences:**
1. The optimal approach avoids recalculating heights by combining the height calculation and balance check in a single pass.
2. The brute force approach recalculates heights multiple times, leading to O(n²) time complexity.
3. The optimal approach uses a special value (-1) to indicate an unbalanced subtree, which propagates up the call stack.

**When to use which approach?**
- Use the optimal approach for better time complexity.
- The brute force approach is simpler to understand but less efficient for large trees.
