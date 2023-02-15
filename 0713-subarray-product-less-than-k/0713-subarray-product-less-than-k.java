class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //using sliding window approach
        int n = nums.length;
        
        //Step 1: initialising starting and ending point of the winodw
        int sp = 0;
        int ep = 0;
        
        int WindowPro = 1; //inorder to multipy our values
        
        int ans = 0; // storing the count of subbarrays whose product is less than k
        
        //edge case : as our nums[index] is always greater or equal to 1, we will never get 0 or 1 as the product, 
        if(k == 0 || k == 1){
            return 0;
        }
        
        while(ep < n){
            WindowPro *= nums[ep];
            
            //Step 2: if the subarray product is equal or more than k, reduce the window from the start and divide by the initial starting point
            while(WindowPro >= k){
                WindowPro /= nums[sp]; 
                sp++;// also increase starting point
            }
            
            ans += (ep - sp + 1); //store the length of the wondow in order to get the count of subarrays that are required
            ep++;
            System.out.println(ans + " "+ ep);
        }
        return ans;
    }
}