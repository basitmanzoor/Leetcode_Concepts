class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
         int n = mat.length;
        int m = mat[0].length;

        int lo = 0;
        int hi = n - 1;

        int potentialRow = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mat[mid][m - 1] == x) {
                return true;
            } else if (mat[mid][m - 1] > x) {
                potentialRow = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (potentialRow == -1) {
            return false;
        }

        lo = 0;
        hi = m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mat[potentialRow][mid] == x) {
                return true;
            } else if (mat[potentialRow][mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }
}