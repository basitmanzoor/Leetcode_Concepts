class Solution {
    public boolean allCharPresent(int cwCount[], int tCount[]){
        for(int i=0; i<tCount.length; i++){
            if(tCount[i] > cwCount[i]){
                return false;
            }
        }
        return true;
    }
   public String minWindow(String s, String t){
       //initialising start and end point of the window
       int sp = 0;
       int ep = 0;
       //create arrays to store frequency of t and current window strings
       int cwCount[] = new int[256];
       int tCount[] = new int [256];
       
       //in order to get the output, initialise original start and end point
       int os = -1;
       int oe = -1;
       int ansSize = Integer.MAX_VALUE;
       
       //count the character frequency in t String
       for(int i=0; i< t.length(); i++){
           tCount[t.charAt(i)]++;
       }
       
       while(ep < s.length()){
           cwCount[s.charAt(ep)]++;
           //keeping track of best possible window
           while(allCharPresent(cwCount, tCount)){
               if(ep - sp + 1 < ansSize){
                   ansSize = ep - sp + 1;
                   os =sp;
                   oe = ep;
               }
               //if the window can be reduced from start
               cwCount[s.charAt(sp)]--;
               sp++;
           }
           
           ep++;
       }
       
       if(os == -1){
           return "";
       }
       return s.substring(os, oe+1);
       
       
   }
}