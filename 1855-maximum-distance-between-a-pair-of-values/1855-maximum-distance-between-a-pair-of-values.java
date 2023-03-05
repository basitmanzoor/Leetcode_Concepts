class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, res = 0, n = nums1.length, m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] > nums2[j]) {
                i++;
            }
            else {
                res = Math.max(res, j++ -i);
            }
        }
        return res;
    }
}