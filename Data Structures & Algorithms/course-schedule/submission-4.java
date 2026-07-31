class Solution {
    Map<Integer, List<Integer>> courses = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int n = 0; n < numCourses; n++){
            courses.put(n, new ArrayList<>());
        }

        for(int[] p : prerequisites){
            List<Integer> preReqs = courses.get(p[0]);
            preReqs.add(p[1]);
        }

        for(Integer c : courses.keySet()){
            Set<Integer> visited = new HashSet<>();
            if(!dfs(c, visited)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Integer c, Set<Integer> visited){
        if(visited.contains(c)){
            return false;
        }

        List<Integer> neighbors = courses.get(c);

        visited.add(c);

        if(neighbors.isEmpty()){
            visited.remove(c);
            return true;
        }

        for(Integer neighbor : neighbors){
            if(!dfs(neighbor, visited)){
                return false;
            }
        }  

        courses.put(c, new ArrayList<>()) ;
        visited.remove(c);

        return true;
    }
}
