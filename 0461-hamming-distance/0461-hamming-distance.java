class Solution {
    public int hammingDistance(int a, int b) {
        int ans = a ^ b;
		int count = 0;
		while(ans != 0){
			if((ans & 1) == 1){
				count++;	
			}
			ans = ans>>1;
		}
		return count;
    }
}