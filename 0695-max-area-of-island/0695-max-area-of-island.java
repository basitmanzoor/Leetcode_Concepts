class Solution {
    public int dfs(int[][] grid, int i, int j, int count){
        if(i>=0 && j>=0 && i<grid.length && j< grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            count++;
            System.out.println(count);
            count = dfs(grid, i+1, j, count);
            count = dfs(grid, i-1, j, count);
            count = dfs(grid, i, j+1, count);
            count = dfs(grid, i, j-1, count);
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(grid[i][j] == 1){
                    int temp = dfs(grid, i, j, 0);
                    ans = Math.max(temp, ans);
                }
            }
        }
        return ans;
    }
}