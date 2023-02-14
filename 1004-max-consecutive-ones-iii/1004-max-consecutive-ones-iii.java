class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int numOfZeroesInCurrWindow = 0;
		int sp = 0;
		int ep = 0;
		int ans = 0;

		while(ep<n){
			//end point is visited now
			if(arr[ep] == 0) numOfZeroesInCurrWindow++;

			// -------------------
			// shrink until window is valid
			while(numOfZeroesInCurrWindow > k){
				if(arr[sp] == 0) numOfZeroesInCurrWindow--;
				sp++;
			}
			//on this line of code, our window will always be valid
			ans = Math.max(ans,ep-sp+1);
			ep++;
		}
		return ans;
    }
}