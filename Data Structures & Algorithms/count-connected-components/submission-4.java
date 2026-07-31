class Solution {
    Map<Integer, Set<Integer>> nodes = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            nodes.put(i, new HashSet<>());
        }

        for(int[] edge : edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        
        Set<Integer> visiting = new HashSet<>();
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(i, null, edges, visited);
            }
        }

        return count;
    }

    public boolean dfs(int n, Integer parent, int[][] edges, Set<Integer> visited){
        if(visited.contains(n)){
            return false;
        }

        visited.add(n);

        Set<Integer> neighbors = nodes.get(n);

        if(neighbors.isEmpty()){
            return true;
        }

        for(int neighbor : neighbors){
            dfs(neighbor, n, edges, visited);
        }

        return true;
    }
}
