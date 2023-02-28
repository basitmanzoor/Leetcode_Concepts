class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sp = 0;
		int ep = 0;
		//implementing the sliding window approach
		int sizeAns = Integer.MAX_VALUE;
		int n = nums.length;
		int sum = 0;
		while(ep < n){
			sum += nums[ep];
			//shrinking
			while(sum >= target && sp < n){
			
				int curr_length = ep - sp + 1;
				sizeAns = Math.min(sizeAns, curr_length);
                sum = sum - nums[sp];
				sp++;
			}
			ep++;
		}
       if(sizeAns == Integer.MAX_VALUE) return 0;
		return sizeAns;
    }
}