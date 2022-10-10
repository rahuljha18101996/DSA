/*
Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/submissions/

Problem Statement:
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109

*/
class LongestConsecutive {
    public int longestConsecutiveBF(int[] a) {
        if (a.length == 0) return 0;
        Arrays.sort(a);
        for (int i : a) System.out.print(i + " ");
        System.out.println();
        int max = 1;
        int counter = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) continue;
            else if ((a[i] + 1) == a[i + 1]) {
                counter++;
            }else {
                max = Math.max(max,counter);
                counter = 1;
            }
        }
        max = Math.max(max,counter);
        return max;
    }
    
    public int longestConsecutive(int[] nums) {
        Set<Integer> num = new HashSet<>();
        for (int i : nums) num.add(i);
        int n = 0;
        for (int i : num) {
            if (!num.contains(i - 1)) {
                int c_count = 1;
                int c_num = i;
                while (num.contains(c_num + 1)) {
                    c_count += 1;
                    c_num += 1;
                }
                n = Math.max(n, c_count);
            }
        }
        return n;
    }
}
