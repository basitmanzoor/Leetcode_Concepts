class Solution {
    public boolean dfs(int currNode, int color, ArrayList<ArrayList<Integer>> graph, int[] visited){
		visited[currNode] = color;
		int nbrColor = color == 1 ? 2 : 1;
		for(int nbr : graph.get(currNode)){
			//if the neighbour has same color, it will return false
			if(visited[nbr] == color){
				return false;
			}
			//if the neighour has not been colored yet
			else if(visited[nbr] == 0){
				boolean checkit = dfs(nbr, nbrColor, graph, visited);
				if(!checkit) return false;
			}
		}
		return true;
	}
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //create a graph first
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for(int i =0 ; i<=n ;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int[] edge : dislikes){
			int u = edge[0];
			int v = edge[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int[] visited = new int[n+1];

		for(int i=1; i<=n; i++){
			if(visited[i] != 0){
				continue;
			}
			boolean check = dfs(i, 1, graph, visited);
			if(!check) return false;
		}
		return true;
    }
}