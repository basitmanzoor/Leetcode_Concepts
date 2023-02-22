//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public void dfs(int currNode, ArrayList<ArrayList<Integer>> graph, boolean visited[], ArrayList<Integer> getAns){
        //mark true
        visited[currNode] = true;
        
        //do the work
        getAns.add(currNode);

        for(int nbr : graph.get(currNode)){
            if(!visited[nbr]){
                dfs(nbr, graph, visited, getAns);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        // Create a graph first
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // for(int i=0; i<V; i++){
        //     ans.add(new ArrayList<Integer>());
        // }
        
        boolean visited[] = new boolean[V];
        
        // for(ArrayList<Integer> edge : graph){
        //     int u = edge.get(0);
        //     int v = edge.get(1);
        //     ans.get(u).add(v);
        //     ans.get(v).add(u);
        // }
        ArrayList<Integer> getAns = new ArrayList<>();
        
        dfs(0, graph, visited, getAns);
        
        return getAns;
    }
}