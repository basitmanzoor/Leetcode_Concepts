class Solution {
    public int getSumK(int[] rows, int k){
        //function to get the max sum less than or equal to k, we will be traversing for every possible combinations
        //thats why we take nested loops
        int myAns = Integer.MIN_VALUE;
        
        for(int i =0; i<rows.length; i++){
            int currSum = 0;
            for(int j=i; j<rows.length; j++){
                currSum +=rows[j];
                if(currSum <=k)
                myAns = Math.max(myAns, currSum);
            }
        }
        
        return myAns;
    }
    public int maxSumSubmatrix(int[][] arr, int k) {
        int ans = Integer.MIN_VALUE;
        for(int left= 0; left <arr[0].length; left++){ //traversing on columns first
            //when left is initialised row array is created
            int rows[] = new int[arr.length];
            for(int right = left; right<arr[0].length; right++){
                //it will increase the row length inorder to add prev elements in the new rows created
                for(int i=0; i<arr.length; i++){
                    rows[i] += arr[i][right];
                }
                //inorder to get the max sum from the row created
                ans = Math.max(ans, getSumK(rows, k));
            }
        }
        
        return ans;
        
    }
}