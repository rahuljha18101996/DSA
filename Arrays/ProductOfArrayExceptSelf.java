/*
Problem Url: https://leetcode.com/problems/product-of-array-except-self/

Problem Statement:
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

*/

class Solution {
    public int[] productExceptSelfBF(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                result[i] *= i == j ? 1 : nums[j];
            }
        }
        return result;
    }

  /*
  We can calculate left and right side of an element and store in left and right array. Return Multiplication of both array.
  */  
  
  public int[] productExceptSelfOptimized(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] left = new int[nums.length];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) count *= nums[i - 1];
            left[i] = count;
        }

        count = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1) count *= nums[i + 1];
            product[i] = left[i] * count;
        }

        return product;
    }
}
