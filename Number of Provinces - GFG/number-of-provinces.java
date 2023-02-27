//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    void dfs(ArrayList<ArrayList<Integer>> M, int[] visited, int i)
    {
        for (int j = 0; j < M.size(); j++)
        {
            if (i!=j && M.get(i).get(j) == 1 && visited[j] == 0)
            {
                visited[j] = 1; //mark as visited
                dfs(M, visited, j);
            }
        }
    }
    
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //create a visited array to mark the elements that has been visited once
        int[] visited = new int[adj.size()];
        int count = 0; //counting the number of provinces
        //start from 0 because of zero based indexing
        for (int i = 0; i < adj.size(); i++)
        {
            //only visited if element is not visited before, we do this when the edges are not alwas connected
            if (visited[i] == 0)
            {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }
};