class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int stepArray[] = new int[1005];
		int n = trips.length;
		//Make a step Array that will contains no of people at the start, and drop no of people at end + 1
		for(int i=0; i<n; i++){
			int people = trips[i][0];
			int start = trips[i][1];
			int end = trips[i][2];

			stepArray[start] += people;
			stepArray[end] -= people;
		}
		//create prefix array based on step array
		int prefixSum[] = new int[1005];

		prefixSum[0] = stepArray[0];
		for(int i=1; i<1005; i++){
				prefixSum[i] = stepArray[i] + prefixSum[i-1];
		}

		//if the value of element increase the capacity, we return false
		for(int i=0; i<prefixSum.length; i++){
			if(prefixSum[i] > capacity){
				return false;
			}
		}
		return true;
    }
}