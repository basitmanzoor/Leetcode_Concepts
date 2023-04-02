class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lt = new ArrayList<>();
        String ans = "";
        helper(lt, n, n, ans);
        return lt;
    }
    
    public void helper(List<String> lt, int open, int close, String ans){
        //base case
        if(open == 0 && close == 0){
            lt.add(ans);
            return;
        }
        
        //recursive case
        if(open != 0){
            helper(lt, open-1, close, ans+"(");
        }
        if(close > open){
            helper(lt, open, close -1, ans+")");
        }
       
    }
}