class Solution {
    public int[] findOrder(int n, int[][] pre) {
        //Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i =0;i<n;i++) graph.add(new ArrayList<>());
		int[] indegree = new int[n];
		for(int[] e: pre){
			graph.get(e[1]).add(e[0]);
			indegree[e[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0;i<n;i++) if(indegree[i] == 0) q.add(i);
		boolean[] vis = new boolean[n];
		int idx = 0;
		int[] ans = new int[n];
		while(q.size()>0){
			int front =q.remove();
			ans[idx] = front;
			idx++;
			for(int nbr:graph.get(front)){
				indegree[nbr]--;
				if(indegree[nbr] == 0) q.add(nbr);
			}
		}
		if(idx<n)return new int[0];
		return ans;
    }
}