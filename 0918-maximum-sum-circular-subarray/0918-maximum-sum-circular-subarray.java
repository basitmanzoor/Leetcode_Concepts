class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //initialise values for calculating max sum subarrray
        int maxSumSubarray = -100000;
        int currMax = maxSumSubarray;
        
        //initialise values for calculating min sum subarray
        int minSumSubarray = 100000;
        int currMin = minSumSubarray;
        
        int wholeSum = 0;
        
        for(int i=0; i<nums.length;i++){
            //Step 1: to get whole sum of given array
            wholeSum += nums[i];
            
            //Step 2: get maximum sum subarray 
            int newVal = nums[i];
            int newWithOld = nums[i] + currMax;
            
            currMax = Math.max(newVal, newWithOld);
            maxSumSubarray = Math.max(maxSumSubarray, currMax);
            
            //Step 3: get Minimum sum subarray
            int newVal1 = nums[i];
            int newWithOld1 = nums[i] + currMin;
            
            currMin = Math.min(newVal1, newWithOld1);
            minSumSubarray = Math.min(minSumSubarray, currMin);
        }
        
        //Step 3: if all the elements in the array are negative
        if(wholeSum == minSumSubarray){
            return maxSumSubarray; //return the max possible subarray
        }
        
        //Step 4: Return the max of either straight array or circular array
        return Math.max(maxSumSubarray, wholeSum - minSumSubarray);
    }
}