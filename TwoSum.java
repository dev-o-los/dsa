class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
           Integer compIdx = map.get(nums[i]);
        if(compIdx!=null){
         return new int[]{compIdx,i};
        }

        map.put(target-nums[i],i);

        }

        return nums;
    }
}
