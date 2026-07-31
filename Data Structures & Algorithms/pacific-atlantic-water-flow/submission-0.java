class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<int[]> atlantic = new ArrayList<>();
        //get all on the bottom border
        for(int i = 0; i < heights[0].length; i++){
            int lastRow = heights.length-1;
            int[] coordinate = {lastRow, i};
            atlantic.add(coordinate);
        }

        //get all on the right border
        for(int i = 0; i < heights.length-1; i++){
            int lastCol = heights[i].length-1;
            int[] coordinate = {i, lastCol};
            atlantic.add(coordinate);
        }

        List<int[]> pacific = new ArrayList<>();
        //get all on the left border
        for(int i = 0; i < heights.length; i++){
            int firstCol = 0;
            int[] coordinate = {i, firstCol};
            pacific.add(coordinate);;
        }

        //get all on the top border
        for(int i = 1; i < heights[0].length; i++){
            int firstRow = 0;
            int[] coordinate = {firstRow, i};
            pacific.add(coordinate);
        }

        //run dfs on atlantic borders
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];

        for(int[] coordinate : atlantic){
            System.out.println(coordinate[0] + ", " + coordinate[1]);
            if(!visitedAtlantic[coordinate[0]][coordinate[1]]){
                dfs(coordinate, heights, visitedAtlantic);
            }
        }

        //run dfs on pacific borders
        boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];

        for(int[] coordinate : pacific){
            if(!visitedPacific[coordinate[0]][coordinate[1]]){
                dfs(coordinate, heights, visitedPacific);
            }
        }

        //find inderstections
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[i].length; j++){
                if(visitedAtlantic[i][j] && visitedPacific[i][j]){
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);

                    result.add(coordinate);
                }
            }
        }

        return result;
        
    }

    public void dfs(int[] coordinate, int[][] heights, boolean[][] visited){
        if(visited[coordinate[0]][coordinate[1]]){
            return;
        }

        visited[coordinate[0]][coordinate[1]] = true;

        List<int[]> neighbors = getNeighbors(coordinate, heights, visited);

        for(int[] neighbor : neighbors){
            dfs(neighbor, heights, visited);
        }

    }

    public List<int[]> getNeighbors(int[] p, int[][] grid, boolean[][] visited){
        List<int[]> neighbors = new ArrayList<>();
        int x = p[0], y = p[1];

        //left neighbor
        if(y > 0){
            if(!visited[x][y-1] && grid[x][y-1] >= grid[x][y]){
                int[] coordinate = {x, y-1};
                neighbors.add(coordinate);
            }
        }

        //right neighbor
        if(y < grid[x].length-1){
            if(!visited[x][y+1] && grid[x][y+1] >= grid[x][y]){
                int[] coordinate = {x, y+1};
                neighbors.add(coordinate);
            }
        }

        //top neighbor
        if(x > 0){
            if(!visited[x-1][y] && grid[x-1][y] >= grid[x][y]){
                int[] coordinate = {x-1, y};
                neighbors.add(coordinate);
            }
        }

        //bottom neighbor
        if(x < grid.length-1){
            if(!visited[x+1][y] && grid[x+1][y] >= grid[x][y]){
                int[] coordinate = {x+1, y};
                neighbors.add(coordinate);
            }
        }

        // System.out.println("\nValid neighbors of " + p[0] + ", " + p[1] + ": ");
        // for(int[] n : neighbors){
        //     System.out.println(n[0] + ", " + n[1]);
        // }

        return neighbors;
    }
}
