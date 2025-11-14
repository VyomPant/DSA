# Search in Rotated Sorted Array – Notes

## 🔍 Logic Summary
We use **modified binary search**.  
Even though the array is rotated, **one half is always sorted** at each step.

Steps:
1. Compute `mid`
2. If `nums[mid] == target`, return the index
3. Determine which half is sorted
    - If `nums[left] <= nums[mid]` → left half is sorted
    - Else → right half is sorted
4. Check if target lies in the sorted half
    - If yes → search in that half
    - Else → search in the other half
5. Continue until `left > right`

This ensures **O(log n)** time.

---

## 🧠 Detailed Explanation

### ✔ Identifying the Sorted Half
A rotated sorted array has two sorted segments created by the pivot.  
At any point:
if (nums[left] <= nums[mid])
left half is sorted
else
right half is sorted


### ✔ Deciding Where to Search
After identifying the sorted segment:

If **left half is sorted**:

if nums[left] <= target < nums[mid]:
move right = mid - 1
else:
move left = mid + 1


If **right half is sorted**:

if nums[mid] < target <= nums[right]:
move left = mid + 1
else:
move right = mid - 1


This eliminates half the array each iteration.

---

## 📝 Dry Run Example
Array: `[4, 5, 6, 7, 0, 1, 2]`  
Target: `0`

| Step | left | mid | right | nums[mid] | Sorted Half | Target in sorted half? | Action |
|------|------|-----|--------|-----------|-------------|-------------------------|--------|
| 1 | 0 | 3 | 6 | 7 | Left (4–7) | No | Search right → left = 4 |
| 2 | 4 | 5 | 6 | 1 | Left (0–1) | Yes | Search left → right = 4 |
| 3 | 4 | 4 | 4 | 0 | — | Found | Return 4 |

Result → **index 4**

---

## 🗣 Interview Explanation (Short)
“At each iteration, I determine which half of the array is sorted. If the target lies inside the sorted half, I search there; otherwise I search the other half. Since I eliminate half the array each time, time complexity is O(log n).”

---

## 🧩 Edge Cases
- Empty array
- Single element array
- Target not present
- Rotation at any index
- No duplicates (duplicates require a modified solution)

---

## 🏁 Quick Revision Checklist
- [ ] One half always sorted
- [ ] Detect sorted half using `nums[left] <= nums[mid]`
- [ ] Check if target lies inside that half
- [ ] Move `left` or `right` accordingly
- [ ] Time complexity = **O(log n)**

