class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++){
            for(int j =i+1;j<n;j++){
                long target2 = Long.valueOf(target) - nums[i]-nums[j] ;
                int front = j+1;
                int back = n-1;
                
                while(front < back){
                    int two_sum = nums[front]+nums[back];
                    if(two_sum < target2){
                        front++;
                    }
                    else if(two_sum > target2){
                        back--;   
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);
                        
                        // processing duplicates at number 3
                        
                        while(front< back && nums[front] == quad.get(2)) {
                            front++;
                        }
                        // processing duplicates at number 4
                        while(front< back && nums[back] == quad.get(3)) {
                            back--;
                        }
                        
                    }
                }
                
                 // processing duplicates at number 2
                while(j+1<n && nums[j+1] == nums[j]) {
                    j++;
                }
                 // processing duplicates at number 1
                while(i+1<n && nums[i+1] == nums[i]) {
                    i++;
                }
            }
        }
        return res;
    }
}