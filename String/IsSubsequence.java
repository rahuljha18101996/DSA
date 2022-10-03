/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

Refer to question : https://leetcode.com/problems/is-subsequence/
*/
public class Main {
    /*
    *
    * Approach 1
    * Returning true if string 's' is empty since empty string is subsequence of every string
    * Taking a counter with 0 initial value
    * Traversing through the characters of the string t
    * if character from t match with character at position counter in string s then increasing the counter
    * checking and returning if the counter is equal to the length of string s
    *
    * */
    public boolean isSubsequence_Method1(String s, String t) {
        if (s.isEmpty()) return true;
        int count = 0;
        for (char ch : t.toCharArray()) {
            if (count >= s.length()) break;
            if (ch == s.charAt(count)) count++;
        }
        return count == s.length();
    }

    /*
     *
     * Approach 2
     * Approach 2 is almost similar to Approach 1
     * DRY RUN
     * s = "abc" t = "abbdc"
     * |--------|-------|-------|-------|-----------------------|-----------------------------------|
     * |    i   |   j   |   sL  |   tL  |   (i < sL && j < tL)  |   (s.charAt(i) == t.charAt(j))    |
     * |--------|-------|-------|-------|-----------------------|-----------------------------------|
     * |    0   |   0   |   3   |   5   |           -           |                -                  |
     * |    0   |   0   |   3   |   5   |           true        |               true                |
     * |    1   |   1   |   3   |   5   |           true        |               true                |
     * |    2   |   2   |   3   |   5   |           true        |               false               |
     * |    2   |   3   |   3   |   5   |           true        |               false               |
     * |    2   |   4   |   3   |   5   |           true        |               true                |
     * |    3   |   5   |   3   |   5   |           false       |                -                  |
     * |--------|-------|-------|-------|-----------------------|-----------------------------------|
     * 
     * returning i == sL (which is true for above case)
     *
     * */
    public static boolean isSubsequence_Method2(String s, String t) {
        if (s.isEmpty()) return true;
        int i = 0, j = 0;
        int sL = s.length(),tL = t.length();
        while (i < sL && j < tL) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == sL;
    }
}
