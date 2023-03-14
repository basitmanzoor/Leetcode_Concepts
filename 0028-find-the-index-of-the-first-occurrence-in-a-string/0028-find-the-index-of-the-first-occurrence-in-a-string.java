class Solution {
    public int strStr(String haystack, String needle) {
        // int s1 = haystack.length();
        // int s2 = needle.length();
        // int index = -1;

        // if(s1<s2){
        //     index = -1;
        // }
        // else{
        // //checks if substrings are equal
        // for(int i = 0; i<=s1-s2; i++){
        //     if(needle.equals(haystack.substring(i,i+s2)) == true){
        //         index = i;
        //         break;
        //     }
        // }
        // //Comparing last elements of haystack with needle. (corner case)
        // if(index < 0){
        //     if(needle.equals(haystack.substring(s1-s2)) == true){
        //          index = s1-s2;
        // }
        // }
        // }
        
        // return index;
        return haystack.indexOf(needle);
    }
}