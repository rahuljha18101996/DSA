/*

Problem URL: https://leetcode.com/problems/two-sum/

Problem Statement:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/
class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        /*
         We can use Hash Map to store the value with its index.
        */
        
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]),i};
            map.put(nums[i],i);
        }
        return new int[0];
    }
    
    public int[] twoSumNested(int[] nums, int target) {
        /*
         Since we are only adding two values so we can use nested loop to find the target sum.
        */
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        return new int[0];
    }
}
