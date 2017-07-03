import java.util.*;

class SubsetDup {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, results);
        
         return results;
        
        
    }
    public void helper(int[] nums, int startIndex, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results){
        results.add(new ArrayList<Integer>(subset));

        System.out.println("Recursively in the helper， current subset is: ");
        for (Integer element : subset) {
          System.out.println(element);
        }

        for(int i=startIndex; i<nums.length; i++){
            if (i != startIndex && nums[i]==nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);

            System.out.println("Before recursive call, the integer i is now: " + i);
            helper(nums, i+1, subset, results);

            System.out.println("After recursive call, the integer i is now: " + i);
            System.out.println("In the for loop， current subset is: ");
            for (Integer element : subset) {
              System.out.println(element);
            }

            subset.remove(subset.size()-1);
        }
    }
    public static void main(String[] args) {
      int[] nums = {1,2,2,2,3};
      SubsetDup sub = new SubsetDup();
      sub.subsets(nums);
    }
}
