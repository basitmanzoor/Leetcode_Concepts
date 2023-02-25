class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int k =0;
        while(num != 0){
            if((num & 1) != 1){
                ans += (int)(Math.pow(2,k));
            }
            num = num>>1;
            k++;
        }
        return ans;
    }
}