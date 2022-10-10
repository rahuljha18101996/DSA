/*
Problem URL: https://leetcode.com/problems/top-k-frequent-elements/

Problem Statement : 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
*/

class TopKFrequentElements {
    /*
    Step 1: Caculating the Frequency of elemts of an array
    Step 2: Sorting the Array based on their frequency
    Step 3: Returning the last k element of the sorted arry
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int[][] mapToArray = new int[map.size()][2];
        int index = 0;
        for (var pair : map.entrySet()) {
            mapToArray[index][0] = pair.getKey();
            mapToArray[index++][1] = pair.getValue();
        }

        Arrays.sort(mapToArray, Comparator.comparingInt(o -> o[1]));

        index = 0;
        int[] result = new int[k];
        for (int i = mapToArray.length - 1; i >= 0 && index < k; i--) {
            result[index++] = mapToArray[i][0];
        }

        return result;
    }
}
