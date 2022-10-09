/*
PROBLEM LINK: https://leetcode.com/problems/merge-intervals/
*/

/*
PROBLEM STATEMENT: 

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        int j;
        List<int[]> a = new ArrayList();
        //Complexity of sorting the array is O(nlog(n))
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //Complexity of below loop is O(n) since we over traversing the array 1 time.
        for (int i = 0; i < intervals.length;) {
            int max = intervals[i][1];
            for (j = i + 1; j < intervals.length; j++) {
                if (max >= intervals[j][0]) max = Math.max(max,intervals[j][1]);
                else break;
            }
            a.add(new int[]{intervals[i][0],max});
            i = j;
        }
        //Overall Complexity is O(nlog(n))
        return a.toArray(new int[a.size()][2]);
    }
}
