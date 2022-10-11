/*
Problem Url: https://leetcode.com/problems/valid-palindrome/

Problem Statement :
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

*/

class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        if (s.equals("") || s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9'))) {
                left++;
                continue;
            }
            if (!((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9'))) {
                right--;
                continue;
            }
            if (leftChar == rightChar) {
                left++;
                right--;
            }else {
                break;
            }
        }
        return left > right;
    }
}
