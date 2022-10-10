/*
Problem Url: https://leetcode.com/problems/group-anagrams/

Problem Statement:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

*/

class GroupAnagrams {
    /*
    In Brute force checking anagram with first index of list if there is list in result otherwise creating a new list.
    */
    public List<List<String>> groupAnagramsBF(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            result.add(List.of(strs[0]));
            return result;
        }
        
        for (String str : strs) {
            if (result.size() == 0) {
                result.add(getList(str));
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < result.size(); i++) {
                if (isAnagram(result.get(i).get(0),str)) {
                    result.get(i).add(str);
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                result.add(getList(str));
            }
        }
        
        return result;
    }
  
    public boolean isAnagram(String s,String t) {
        int[] letterCounter = new int[26];
        for (char ch : s.toCharArray()) letterCounter[ch - 'a']++;
        for (char ch : t.toCharArray()) letterCounter[ch - 'a']--;
        for (int i : letterCounter) if (i != 0) return false;
        return true;
    }
  
    /*
    In the below approach I am using sorted string for key in Hashmap. if two sorted string are equal then they are anagram of each other.
    */
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            result.add(List.of(strs[0]));
            return result;
        }
        
        Map<String,List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            if (map.size() == 0) {
                map.put(sort(str),getList(str));
                continue;
            }
            boolean flag = true;
            String s = sort(str);
            
            if (map.containsKey(s)) {
                map.get(s).add(str);
            }else {
                map.put(sort(str),getList(str));
            }
        }
        
        for (List<String> val : map.values()) {
            result.add(val);
        }
        
        return result;
    }
    
    public String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
  
    public List<String> getList(String s) {
        List<String> list = new ArrayList<>();
        list.add(s);
        return list;
    }
    
}
