class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while(start<end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                return new int[] {start+1,end+1};
            }
            if (sum > target){
                end--;
            }
            else{
                start++;
            }
        }
        return new int[]{};
    }
}