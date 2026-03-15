class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            if (numMap.containsKey(nums[i])){
                return true;
            } else {
                numMap.put(nums[i],i);
            }
        }
        return false;
    }
}

/* Instead of HashMap I can use hashSet
 * 
 * 
 * class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i=0; i<nums.length; i++){
            if (numSet.contains(nums[i])){
                return true;
            } else {
                numSet.add(nums[i]);
            }
        }
        return false;
    }
 */