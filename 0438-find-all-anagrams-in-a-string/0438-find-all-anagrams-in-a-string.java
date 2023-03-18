class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();

        // 1. No solution, immediately return to prevent errors.
        if (pLen > sLen) return res;
        int[] sArr = new int[26];
        int[] pArr = new int[26];

        // 2. Record the number of letters for entire p and s from 0
        // to pLen - 1
        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        // 3. Quick edge case check for index 0
        if (isAnagram(sArr, pArr)) res.add(0);

        // 4. For each index -> sLen, expand and shrink window
        // to maintain fixed pLen, update hashmap array, and 
        // perform a check.
        for (int i = pLen; i < sLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            sArr[s.charAt(i - pLen) - 'a']--;
            if (isAnagram(sArr, pArr)) res.add(i - pLen + 1);
        }

        return res;

    }
    
    private boolean isAnagram(int[] sarr, int[] parr) {
        return Arrays.equals(sarr, parr);
    }
}