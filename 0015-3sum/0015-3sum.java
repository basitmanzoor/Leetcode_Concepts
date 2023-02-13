class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //create a list for answers
       List<List<Integer>> mp = new LinkedList<>();
        //inorder to use the 2 pointer approach, we need to sort the array first
       Arrays.sort(nums);
        //taking first integer out of triplets, and running loop from 0 to n-1, as last two elements will be other part of triplet
       for(int i=0;i<nums.length-2;i++)
       {
           if(i==0 ||(i>0 && nums[i]!=nums[i-1]))
           {
               //initializing other two ints of triplet
               int low=i+1;
               int high=nums.length-1;
               
               //if a + b + c = 0, then b + c = - c
               int newTarget=0-nums[i];
               
               //using the 2 pointer approach of 2sum
               while(low<high)
               {
                   int sum = nums[low]+nums[high];
                   if(sum == newTarget)
                   {
                       //adding each triplet found
                       mp.add(Arrays.asList(nums[i],nums[low],nums[high]));
                       //checking for duplicates
                       while(low<high && nums[low]==nums[low+1])
                       {
                           low++;
                       }
                       //checking for duplicates
                       while(low<high && nums[high]==nums[high-1])
                       {
                           high--;
                       }
                       low++;
                       high--;
                   }
                   else if(sum < newTarget)
                   {
                       low++;
                   }
                   else
                   {
                       high--;
                   }
               }
           }
       }
       return mp;
    }
}