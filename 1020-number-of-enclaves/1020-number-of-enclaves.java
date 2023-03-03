class Solution {
    public void destroy(int i, int j,int[][] grid){
		if(i < 0 || j<0|| i==grid.length || j==grid[0].length) return;
		if( grid[i][j] == 0) return;
		grid[i][j] = 0;//destroying an island
		destroy(i-1,j,grid);//up
		destroy(i,j-1,grid);//left
		destroy(i+1,j,grid);//down
		destroy(i,j+1,grid);//right
	}
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
	  int m = grid[0].length;
	  for(int i = 0;i<n;i++){
		  if(i == 0){
			  for(int j = 0;j<m;j++) destroy(i,j,grid);
		  }else if(i == n-1){
			  for(int j = 0;j<m;j++) destroy(i,j,grid); 
		  }else{
			destroy(i,0,grid);
			destroy(i,m-1,grid);
		  }
	  }
	  int cnt = 0;
	  for(int i = 0;i<n;i++){
		  for(int j = 0;j<m;j++){
			cnt+=grid[i][j];// add all the good land cells together
		  }
	  }
	  return cnt;
    }
}