class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) {
            //mark border land cell islands
            markWater(grid, i, 0);
            //mark border land cell islands
            markWater(grid, i, n - 1);
        }
        for(int j=0;j<n;j++) {
            //mark border land cell islands
            markWater(grid, 0, j);
            //mark border land cell islands
            markWater(grid, m - 1, j);
        }
        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    ans++;
                    //if there is a land cell, increment the answer and mark all 4-directional neighbours as visited or a special symbol.
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    //marks every land cell as water that are attached to border land cell
    static void markWater(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        markWater(grid, i - 1, j);
        markWater(grid, i, j - 1);
        markWater(grid, i + 1, j);
        markWater(grid, i, j + 1);
    }
    //marks all 4-directional neighbours as special symbol
    static void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1 || grid[i][j] == 2)
            return;
        grid[i][j] = 2;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}