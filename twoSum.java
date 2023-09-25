//Problem Number 1
public class twoSum {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            System.out.println(numMap);
            for (int i = 0; i < nums.length; i++) {
                if (numMap.containsKey(target - nums[i])) {
                    return new int[]{numMap.get(target - nums[i]), i};
                }
                numMap.put(nums[i], i);
            }
            return new int[]{};
        }
}
