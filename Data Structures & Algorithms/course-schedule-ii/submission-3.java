class Solution {
    Map<Integer, List<Integer>> courses = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int n = 0; n < numCourses; n++){
            courses.put(n, new ArrayList<>());
        }

        for(int[] p : prerequisites){
            List<Integer> preReqs = courses.get(p[0]);
            preReqs.add(p[1]);
        }

        for(Integer c : courses.keySet()){
            Set<Integer> visiting = new HashSet<>();
            if(!dfs(c, visiting)){
                return new int[0];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }

    public boolean dfs(Integer c, Set<Integer> visiting){
        if(visited.contains(c)){
            return true;
        }
        
        if(visiting.contains(c)){
            return false;
        }

        List<Integer> neighbors = courses.get(c);

        visiting.add(c);
        
        if(neighbors.isEmpty()){
            visiting.remove(c);
            if(!visited.contains(c)){
                result.add(c);
                visited.add(c);
            }
            return true;
        }

        for(Integer neighbor : neighbors){
            if(!dfs(neighbor, visiting)){
                return false;
            }
            
        }  

        if(!visited.contains(c)){
            result.add(c);
            visited.add(c);
        }

        courses.put(c, new ArrayList<>()) ;
        visiting.remove(c);

        return true;
    }
}
