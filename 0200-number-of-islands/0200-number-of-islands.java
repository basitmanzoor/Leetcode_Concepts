class Solution {
    public void dfs(char[][] grid, int i, int j){
        //here we will be checking for 1's and its adjecent 1's which will make an island
        //after visiting every 1, we will make it zero so that it is not visited again
        //check for the out of bount conditions as well
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i+1, j); //right
            dfs(grid, i-1, j); //left
            dfs(grid, i, j+1); //down
            dfs(grid, i, j-1); //up
        }
    }
    public int numIslands(char[][] grid) {
        int count =0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}