/*
Problem URL: https://leetcode.com/problems/valid-anagram/

Problem Statement:

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/

class IsValidAnagram {
    
    public boolean isAnagram(String s, String t) {
        /*
        Since given strings contains only lowercase character we can create an array of integer of size 26 (In java default value for int is 0). Increasing counter for one string and decreasing for another string, so at last all value should be zero. 
        */
        if (s.length() != t.length()) return false;
        
        int[] letterCounter = new int[26];
        for (char ch : s.toCharArray()) letterCounter[ch - 'a']++;
        for (char ch : t.toCharArray()) letterCounter[ch - 'a']--;
        for (int i : letterCounter) if (i != 0) return false;
        return true;
    }
    
    public boolean isAnagramUsingSorting(String s, String t) {
        /*
        Brute force solution: Sorting both string and then comparing the string
        */
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return new String(s1).equals(new String(t1));
        
    }
}
