class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //using the sliding window approach
        int i = 0;
        
        int count = 0; //size of the window
        int ans = 0;
        while(i < nums.length){
            if(nums[i] == 1){
                count++;
            }
            else{
                count = 0; 
            }
            ans = Math.max(ans, count);
            i++;
        }
        return ans;
        
    }
}