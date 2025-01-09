package neetCode150.twoPointers;

// https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    /*- Time complexity:O(n)
         Space complexity:O(1)
      */
    public static boolean isPalindromeUsingTwoPointers(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) { // ignoring alphanumeric characters
                left++;
            }
            while (right > left && !Character.isLetterOrDigit(s.charAt(right))) { // ignoring alphanumeric characters
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // use Character.isLetterOrDigit(char c) instead of this
    private static boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    /*- Time complexity:O(n)
      Space complexity:O(n)
   */
    public static boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeUsingTwoPointers(s));
    }
}
