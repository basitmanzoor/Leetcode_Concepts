class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            adjList.get(e[0]).add(new double[]{e[1],succProb[i]});
            adjList.get(e[1]).add(new double[]{e[0],succProb[i]});
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b)->{
            return Double.compare(b[1],a[1]);
        });
        
        pq.add(new double[]{start,1.0});
        
        double[] dist = new double[n];
        dist[start] = 1.0;
        
        while(pq.size() > 0){
            double[] node = pq.poll();
            int u = (int)node[0];
            if(u == end)
                return node[1];
            
            for(double[] vertex : adjList.get(u)){
                int v = (int)vertex[0];
                double prob = vertex[1];
        
                if(dist[v] < dist[u] * prob){
                    dist[v] = dist[u] * prob;
                    pq.add(new double[]{v,dist[v]});
                }
            }
        }
        
        return 0.0;
    }
}