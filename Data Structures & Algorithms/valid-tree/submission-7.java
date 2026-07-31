class Solution {
    Map<Integer, List<Integer>> nodes = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            nodes.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        
        Set<Integer> visiting = new HashSet<>();

        if(!dfs(0, null, edges, visited)){
            return false;
        }

        if(visited.size() != n){
            return false;
        }


        return true;
    }

    public boolean dfs(int n, Integer parent, int[][] edges, Set<Integer> visited){
        if(visited.contains(n)){
            return false;
        }

        visited.add(n);

        List<Integer> neighbors = nodes.get(n);

        if(neighbors.isEmpty()){
            return true;
        }

        for(int neighbor : neighbors){
            if(parent == null || neighbor != parent){
                if(!dfs(neighbor, n, edges, visited)){
                    return false;
                }
            }
        }

        return true;
    }
}
