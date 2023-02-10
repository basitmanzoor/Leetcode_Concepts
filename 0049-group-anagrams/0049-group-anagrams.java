class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            //create a frequency array
            int freq[] = new int[26];
            //Step 1: get the frequency of characters
            for(int j =0; j < s.length(); j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;
            }

            //create a string code using string builder to make a key for our map
            StringBuilder code = new StringBuilder("");
            for(int j=0; j<26; j++){
                code.append((char)('a'+j));
                code.append(freq[j]);
            }

            if(hm.containsKey(code.toString()) == false){
                ArrayList<String> t = new ArrayList<>();
                hm.put(code.toString(), t);
            }
            ArrayList<String> list = hm.get(code.toString());
            list.add(s);
            hm.put(code.toString(), list);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : hm.keySet()){
            ArrayList<String> grp = hm.get(key);
            ans.add(grp); 
        }
        return ans;
    }
}