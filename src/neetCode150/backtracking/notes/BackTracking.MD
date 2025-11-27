# Backtracking Pattern

## Problem Statement
Backtracking is a general algorithm for finding all (or some) solutions to computational problems, particularly constraint satisfaction problems. It incrementally builds candidates to the solutions and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.

### Example: Subsets
Given an array of distinct integers, return all possible subsets (the power set).

**Input:** `nums = [1,2,3]`  
**Output:** `[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]`

## Approaches

### Backtracking with State Tracking (Time: O(n * 2^n), Space: O(n))
**Intuition:**
- Generate all possible combinations by making a binary choice at each step: include the current element or exclude it
- Use a depth-first search approach to explore all possibilities
- Backtrack by undoing the last choice to explore alternative paths

**Essential Pattern: CHOOSE → EXPLORE → UN-CHOOSE**
This is the heart of backtracking:
1. **CHOOSE**: Pick one option (add element, place queen, move in a maze, etc.)
2. **EXPLORE**: Recursively explore deeper with this choice included
3. **UN-CHOOSE**: Undo the choice (remove element, move back, unmark cell)

This ensures you explore all possible combinations without corrupting the state.

**Template:**
```java
private void backtrack(STATE currentState, PARAMETERS...) {
    // 1. BASE CONDITION: decide when to record / stop
    if (some condition) {
        save currentState (usually make a copy)
        return;
    }

    // 2. LOOP OVER CHOICES
    for (each valid choice 'ch' from current position) {
        // ---------- CHOOSE ----------
        apply choice 'ch' to currentState;

        // ---------- EXPLORE ----------
        backtrack(updatedState, updated parameters);

        // ---------- UN-CHOOSE / BACKTRACK ----------
        undo the choice 'ch' to restore the previous state;
    }
}
```

**Example Implementation (Subsets):**
```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(0, nums, new ArrayList<>(), result);
    return result;
}

private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
    // Save current subset
    result.add(new ArrayList<>(path));
    
    // Explore further choices
    for (int i = start; i < nums.length; i++) {
        // CHOOSE
        path.add(nums[i]);
        
        // EXPLORE
        backtrack(i + 1, nums, path, result);
        
        // UN-CHOOSE
        path.remove(path.size() - 1);
    }
}
```

### Key Observations
1. **Time Complexity**: O(n * 2^n) - There are 2^n possible subsets, and each subset takes O(n) time to build
2. **Space Complexity**: O(n) - The recursion stack goes as deep as the length of the input array
3. **Avoiding Duplicates**: The `start` parameter ensures we don't generate duplicate subsets by always moving forward in the array
4. **State Management**: We maintain the current state (path) and modify it as we explore different choices

### Common Variations
1. **Subsets with Duplicates**: Sort the array first and skip duplicates in the loop
2. **Combination Sum**: Allow reusing elements to reach a target sum
3. **Permutations**: Generate all possible orderings of elements
4. **N-Queens**: Place queens on a chessboard such that no two queens threaten each other

### When to Use Backtracking
- When you need to explore all possible solutions
- When the problem has constraints that can be checked incrementally
- When the solution can be built incrementally
- When the problem requires generating all possible combinations/permutations

### Problem Links
- [Subsets (LeetCode 78)](https://leetcode.com/problems/subsets/)
