/*
Problem URL: https://leetcode.com/problems/3sum/

Problem Statement:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

*/
class ThreeSum {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        if (a[0] > 0) return result;
        for(int i = 0; i < a.length; i++) {
            if (a[i] > 0) break;
            if (i > 0 && a[i - 1] == a[i]) continue;
            int l = i + 1;
            int r = a.length - 1;
            while (l < r) {
                if ((a[i] + a[l] + a[r]) == 0) {
                    result.add(List.of(a[i],a[l],a[r]));
                    l++;
                    while (l < a.length && a[l - 1] == a[l]) l++;
                }
                else if ((a[i] + a[l] + a[r]) > 0) r--;
                else l++;
            }
        }
        return result;
    }
}
