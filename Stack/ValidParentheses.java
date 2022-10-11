/*
Problem URL: https://leetcode.com/problems/valid-parentheses/

Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        boolean flag = true;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch == '(' ? ')' : ch == '[' ? ']' : '}' );
            }else {
                if (stk.size() > 0 && stk.peek() == ch) {
                    stk.pop();
                }else {
                    flag = false;
                    break;
                }
            }
        }
        return flag && stk.size() == 0;
    }
}
