class Solution {
    public int getSum(int a, int b) {
        //Step 1: First XOR a and b
        //step 2: do the AND operation and right shift by 1, which will act as carry
        while (b != 0){
            int temp = (a&b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}