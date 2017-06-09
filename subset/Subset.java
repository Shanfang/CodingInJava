/*
  this is a problem from lintcode http://www.lintcode.com/en/problem/subsets/
  the popurse of this implementation is to show how the recursion works
  by printing out the stack trace
*/
import java.util.*;

class Subset {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>(); 
        if (nums == null) {
            return results;// return an empty list
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        helperSubsets(nums, results, 0, new ArrayList<Integer>());
        return results;
    }
    
    private void helperSubsets(int[] nums, ArrayList<ArrayList<Integer>> results,
                                int startIndex, ArrayList<Integer> currentSubset) {
        results.add(new ArrayList<Integer>(currentSubset));
        // base case
        System.out.println("Enter the helper， current subset is: ");
        for (Integer element : currentSubset) {
          System.out.println(element);
        }
        if (startIndex == nums.length) {
            return;
        }
        
        // recursively adding an integer to a subset
        for (int i = startIndex; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            
            /* here comes the recursion, for [1,2,3], choose 1, then find 
               subsets of [2,3] adding 1 to all the subsets, these are subsets 
               choose 1.For iteration on 2 and 3, those are subsets that do 
               not choose 1
             */
            helperSubsets(nums, results, startIndex + 1, currentSubset);
            
            /*
              remove the current number, and process the next one in nums in the
              next interation 
             */
            System.out.println("Before removing the integer i is now: " + i);
            //currentSubset.remove(nums[i]);
            currentSubset.remove(currentSubset.size() - 1);
        }       
    }

    public static void main(String[] args) {
      int[] nums = {1,2,3};
      subset sub = new subset();
      sub.subsets(nums);
    }
}