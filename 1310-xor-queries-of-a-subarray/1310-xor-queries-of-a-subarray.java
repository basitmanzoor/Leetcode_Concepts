class Solution {
    public void build(int[] pref, int[] arr, int n){
        for(int i=0; i<n; i++){
            pref[i] = arr[i] ^ (i-1 >= 0 ? pref[i-1] : 0);
        }
    }
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        //create a prefixXOR array with size of given array
        int[] pref = new int[n];
        build(pref, arr, n); //building the prefix XOR array
        
        int[] ans = new int[q.length];
        //checking the queries
        for(int i =0; i<q.length; i++){
            //calculating the starting and ending point
            int sp = q[i][0];
            int ep = q[i][1];
            
            if(sp == 0){
                ans[i] = pref[ep];
            }
            else{
                ans[i] = pref[sp-1]^pref[ep];
            }
        }
        return ans;
    }
}