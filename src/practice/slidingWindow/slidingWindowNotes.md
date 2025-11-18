
### Sliding Window Technique

The sliding window is a common technique often used to optimize solutions for problems involving sequences (like arrays or strings).  
It helps reduce the time complexity from \(O(n^2)\) or higher to \(O(n)\) by maintaining a subset of the data within a "window" and moving that window across the data to evaluate conditions.

---

#### How Sliding Window Works

1. **Define a Window**:  
   A window is a subset of elements from a sequence (array or string).  
   It could represent a subarray, substring, or any range of elements you're working with.

2. **Sliding Mechanism**:  
   The window is initially at the start of the sequence.  
   You "slide" it by adding new elements to the end and/or removing elements from the start.

3. **Adjusting Window**:  
   Depending on the problem, you may need to expand or shrink the window dynamically while maintaining a valid state (e.g., the sum, product, or frequency of elements meets certain criteria).

4. **Optimize Solution**:  
   Use the sliding window to avoid redundant calculations, enabling you to solve the problem efficiently.

---

#### Types of Sliding Window Problems

1. **Fixed-size Window**:  
   The window size is predefined and constant.  
   **Example**: Finding the maximum sum of a subarray of size \(k\).

2. **Variable-size Window**:  
   The window size changes dynamically based on conditions.  
   **Example**: Finding the smallest subarray with a sum greater than \(S\).

---

#### Key Points to Remember

- **Fixed-size Window Problems**: Focus on maintaining a constant-sized subset.  
  Example: Finding the maximum sum of a subarray of size \(k\).

- **Variable-size Window Problems**: Involve dynamically adjusting the window size based on conditions.  
  Example: Finding the smallest subarray with a sum greater than \(S\).

- **Optimization**: Sliding window avoids redundant calculations, reducing time complexity to \(O(n)\).

---

This Markdown-friendly structure ensures that the content remains clean and readable, both in its raw and rendered form.



### How to Identify When to Use the Sliding Window Technique

The sliding window technique is a powerful approach for solving problems that involve subsets or ranges within an array or string. Below are key indicators to identify when you can apply this technique:

#### 1. Problem Involves Contiguous Subarrays or Subsequences
If the problem requires finding or optimizing something for a **contiguous subarray or substring**, sliding window is likely applicable. Examples:
- Maximum sum of a subarray of size `k`.
- Longest substring with at most `k` distinct characters.

#### 2. The Problem Requires Optimization Over a Range
Sliding window is useful when the goal is to:
- Maximize or minimize something (e.g., size, sum, or product) over a range.
- Count occurrences or elements meeting certain conditions within a range.

#### 3. Two Pointers Are Naturally Useful
Look for problems where:
- You can increment or decrement one or both pointers to adjust the range.
- The range size dynamically changes based on conditions.

#### 4. Fixed or Variable Window Size
- **Fixed Window Size**: The size of the window is constant (e.g., subarray size = `k`).
- **Variable Window Size**: The window size changes dynamically (e.g., finding the smallest subarray with a sum ≥ target).

---

### Most Frequently Asked Sliding Window Problems

Below is a list of commonly asked sliding window problems in interviews:

#### Easy Problems
1. **Maximum Sum Subarray of Size K**  
   Find the maximum sum of any contiguous subarray of size `k`.  
   **Company**: Amazon, Microsoft.  
   **Source**: Not directly on LeetCode, but available on GeeksForGeeks.

2. **Best Time to Buy and Sell Stock**  
   Find the maximum profit achievable by buying and selling a stock once.  
   **Company**: Google, Facebook, Amazon.  
   **Source**: [LeetCode 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/).

#### Medium Problems
3. **Longest Substring Without Repeating Characters**  
   Find the length of the longest substring without repeating characters.  
   **Company**: Google, Microsoft, Amazon.  
   **Source**: [LeetCode 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/).

4. **Smallest Subarray with a Given Sum**  
   Find the minimal length of a subarray with a sum ≥ target.  
   **Company**: Facebook, Google.  
   **Source**: [LeetCode 209](https://leetcode.com/problems/minimum-size-subarray-sum/).

5. **Sliding Window Maximum**  
   Find the maximum value in every window of size `k`.  
   **Company**: Facebook, Microsoft.  
   **Source**: [LeetCode 239](https://leetcode.com/problems/sliding-window-maximum/).

6. **Permutation in String**  
   Check if one string's permutation is a substring of another string.  
   **Company**: Amazon, Google.  
   **Source**: [LeetCode 567](https://leetcode.com/problems/permutation-in-string/).

7. **Longest Substring with At Most K Distinct Characters**  
   Find the length of the longest substring with at most `k` distinct characters.  
   **Company**: Amazon, Facebook.  
   **Source**: [LeetCode 340](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) (Premium).

8. **Fruit Into Baskets**  
   You can pick at most 2 types of fruits; find the maximum number of fruits you can collect.  
   **Company**: Amazon, Facebook.  
   **Source**: [LeetCode 904](https://leetcode.com/problems/fruit-into-baskets/).

#### Hard Problems
9. **Subarrays with K Different Integers**  
   Count all subarrays containing exactly `k` distinct integers.  
   **Company**: Google, Amazon.  
   **Source**: [LeetCode 992](https://leetcode.com/problems/subarrays-with-k-different-integers/).

10. **Longest Substring with At Most K Repeating Characters**  
    Find the length of the longest substring where each character appears at least `k` times.  
    **Company**: Google.  
    **Source**: [LeetCode 395](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/).

11. **Maximum Number of Vowels in a Substring of Given Length**  
    Find the maximum number of vowels in any substring of length `k`.  
    **Company**: Amazon.  
    **Source**: [LeetCode 1456](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/).

---

### Key Takeaways
- Use sliding window for problems involving **contiguous subarrays** or **substrings** where optimization is required.
- Sliding window involves **efficiently updating auxiliary variables** (like sum, count, or frequency) as the window slides.
- Practice the problems listed above to master this technique for interviews.
