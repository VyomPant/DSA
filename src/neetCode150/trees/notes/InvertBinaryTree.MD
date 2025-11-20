# 🌳 Invert Binary Tree — DFS vs BFS vs Iterative DFS

#️⃣ Problem Summary
Invert a binary tree by swapping the left and right child of every node.

## ✔ Approach 1 — DFS (Recursive)

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    // Swap children
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Recursively invert subtrees
    invertTree(root.left);
    invertTree(root.right);

    return root;
}
```

### How it works / Intuition
- Recursion naturally fits tree structure
- At each node:
  - Swap the children
  - Recursively invert left subtree
  - Recursively invert right subtree
- Bottom-up inversion of the entire tree

### Complexity
- **Time**: O(n) - Each node is visited once
- **Space**: O(h) where h is height of tree
  - Worst-case (skewed tree): O(n)
  - Best-case (balanced tree): O(log n)

### Pros
- Cleanest and most elegant solution
- Mirrors the tree's natural recursive definition
- Minimal code with clear intent
- Most commonly expected solution in interviews

### Cons
- Risk of stack overflow for very deep trees
- Less efficient for extremely large trees
- Harder to debug with deep recursion

### Use When
- Tree depth is safe (moderately balanced tree)
- Interview prefers recursive solutions
- Code readability is a priority
- You need the most straightforward solution

## ✔ Approach 2 — BFS (Iterative, using Queue)

```java
public TreeNode invertTreeBFS(TreeNode root) {
    if (root == null) return null;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        
        // Swap children
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        // Add children to queue
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
    
    return root;
}
```

### How it works / Intuition
- Processes nodes level by level (top-down)
- Uses a queue to track nodes to process
- For each node:
  - Swap its children
  - Enqueue left and right children
- Continues until all nodes are processed

### Complexity
- **Time**: O(n) - Each node processed once
- **Space**: O(w) where w is maximum width of tree
  - Worst-case (complete tree): O(n/2) ≈ O(n)
  - Best-case (skewed tree): O(1)

### Pros
- No recursion → safe for very deep trees
- Processes nodes level by level
- More memory efficient for wide, bushy trees
- Easier to reason about for level-order operations

### Cons
- More verbose than recursive solution
- Uses more memory for balanced trees
- Slightly more complex control flow

### Use When
- Tree may be very deep (avoid recursion depth issues)
- You need level-order processing
- Interviewer requests an iterative solution
- You need to demonstrate BFS knowledge

## ✔ Approach 3 — Iterative DFS (Using Stack)

```java
public TreeNode invertTreeIterativeDFS(TreeNode root) {
    if (root == null) return null;
    
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        
        // Swap children
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        // Push children to stack (right first for pre-order)
        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
    }
    
    return root;
}
```

### How it works / Intuition
- Simulates recursion using an explicit stack
- Similar to DFS but without recursion
- Order of processing can be controlled (pre-order, in-order, post-order)
- More flexible than recursive approach

### Complexity
- **Time**: O(n) - Each node visited once
- **Space**: O(h) where h is height of tree
  - Worst-case: O(n) for skewed tree
  - Best-case: O(log n) for balanced tree

### Pros
- No recursion → avoids stack overflow
- More control over traversal order
- Better space efficiency than BFS for deep trees
- Demonstrates understanding of DFS internals

### Cons
- More complex than recursive DFS
- Requires explicit stack management
- Slightly more memory than recursive DFS
- Easy to make mistakes in traversal order

### Use When
- Recursion depth is a concern
- You need explicit control over stack
- Interviewer asks for non-recursive DFS
- You need to demonstrate stack usage

## ⭐ Final Comparison Table

| Approach       | Traverse Order | Uses       | Pros                                      | Cons                                    | Best Use Case                          |
|----------------|----------------|------------|-------------------------------------------|-----------------------------------------|----------------------------------------|
| **DFS Recursive** | Pre-order DFS  | Recursion  | Clean, elegant, shortest code             | Stack overflow risk for deep trees      | Standard solution, balanced trees      |
| **BFS**         | Level Order    | Queue      | Safe for deep trees, level-order          | Higher memory for balanced trees        | Very deep or wide trees, level-order   |
| **Iterative DFS**| Pre-order DFS  | Stack      | No recursion, flexible traversal          | More code, manual stack management      | Deep trees, recursion not allowed      |

## ⭐ Recommendation for Interviews

1. **Primary Solution**: DFS Recursive
   - Default choice for most interviews
   - Demonstrates understanding of tree recursion
   - Easy to explain and implement

2. **Backup Solution**: BFS
   - When interviewer asks for iterative solution
   - For level-order related questions
   - When recursion depth is a concern

3. **Advanced Solution**: Iterative DFS
   - When interviewer wants non-recursive DFS
   - To demonstrate stack usage
   - For companies that emphasize iterative solutions (e.g., Amazon, Google)

## 🧠 Keywords / Concepts
- Tree inversion
- Tree symmetry
- DFS (recursive, iterative)
- BFS / Level-order traversal
- Stack vs Queue
- Preorder traversal
- Recursion stack depth
- Tree traversal techniques

## 🔗 Related Problems
- [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
- [Same Tree](https://leetcode.com/problems/same-tree/)
- [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
- [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)