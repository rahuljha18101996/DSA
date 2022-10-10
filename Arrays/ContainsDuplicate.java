import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /*
    Brute force Solution
    
    Step 1 - for i = (0,n - 1)
    Step 2 - for j = (0,n - 1)
    Step 3 - if i != j && a[i] == a[j] return true;
    Step 4 - return false;
    
    Complexity Analysis: O(n^2) - Might give Memory out of bound issue    
    */
    public static boolean containsDuplicateBruteForce(int[] nums) {
        //O(n^2)
         for (int i = 0; i < nums.length; i++) {
             for (int j = 0; j < nums.length; j++) {
                 if (i != j && nums[i] == nums[j]) return true;
             }
         }
         return false;
    }

    /*
    Optimized Solution
    Step 1 - Create a Set as set
    Step 2 - for i = (0,n - 1)
    Step 3 - if (!set.add(a[i])) return true;
    Step 4 - return false
    
    Complexity Analysis: O(n)
    */
    public static boolean containsDuplicateHashSet(int[] nums) {
        //O(n)
         Set<Integer> set = new HashSet<>();
         for (int i : nums) {
             if (!set.add(i)) return true;
         }
         return false;
    }
}
