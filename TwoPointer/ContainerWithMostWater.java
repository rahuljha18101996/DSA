/*
Problem URL: https://leetcode.com/problems/container-with-most-water/

Problem Statement:

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

*/
class ContainerWithMostWater {
    public int maxArea(int[] a) {
        int max = 0;
        int l = 0, r = a.length - 1;
        while (l < r) {
            int cm = Math.min(a[l],a[r]) * (r - l);
            max = Math.max(cm,max);
            if (a[r] > a[l]) l++;
            else r--;
        }
        return max;
    }
}
