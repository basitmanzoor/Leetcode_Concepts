class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        int rev =0;
        boolean flag = false;
        while(x != 0){
            int digit = x%10;
            x = x/10;
            rev = rev*10 + digit;
        }
        if(n == rev){
            flag = true;
        }
        else{
            flag = false;
        }
        if(n<0){
            flag = false;
        }
        return flag;
    }
}