class Solution {
    public int searchInsert(int[] a, int target) {
        int n = a.length;

        int start = 0;
        int end = n-1;

        int ans = n;

        while(start <= end){
            int mid = (start + end)/2;
            if(a[mid] == target){
                return mid;
            }
            else if(a[mid] > target){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;   
    }
}