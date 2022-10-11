/*
Problem URL: https://leetcode.com/problems/generate-parentheses/

Problem Statement:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generate(new char[2 * n],0,parenthesis);
        return parenthesis;
    }
    public void generate(char[] ch,int index,List<String> s) {
        if (index == ch.length) {
            if (validate(ch)) {
                s.add(new String(ch));   
            }
            return;
        }
        if (index == 0) {
            ch[0] = '(';
            generate(ch,1,s);
        }else {
            ch[index] = '(';
            generate(ch,index + 1,s);
            ch[index] = ')';
            generate(ch,index + 1,s);
        }
    }
    public boolean validate(char[] ch) {
        int counter = 0;
        for (char c : ch) {
            if (c == '(') counter++;
            else counter--;
            if (counter < 0) return false;
        }
        return counter == 0;
    }
}
