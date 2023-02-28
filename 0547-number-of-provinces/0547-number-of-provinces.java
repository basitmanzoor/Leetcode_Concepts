class Solution {
    public void dfs(int curr, ArrayList<ArrayList<Integer>> graph, boolean visited[]){
        //simple dfs approach used
        visited[curr] = true;
        for(int nbr : graph.get(curr)){
            if(visited[nbr]) continue;
            dfs(nbr, graph, visited);
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //Step 1: Create a graph from adjacency Matrix
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        //graph from matrix of n x n size
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        //create a visited array to maintain the visited nodes
        boolean visited[] = new boolean[n+1];
        int NoOfPro = 0; //to check the min count needed to visited all nodes/provinces
        
        //this loop is used to visited every node present in the graph even if some nodes are disconnected from other nodes
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, graph, visited);
                NoOfPro++; //everytime a new node is visited, no of provinces will increase
            }
        }
        return NoOfPro;
    }
}