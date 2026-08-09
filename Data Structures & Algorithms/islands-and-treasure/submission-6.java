class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 0){
                    int[] coordinate = {row, col};
                    q.offer(coordinate);
                }
            }
        }

        int level = 1;

        while(!q.isEmpty()){
            //list of all neighbors across all treasures
            List<int[]> nextLevel = new ArrayList<>();

            while(!q.isEmpty()){
                int[] c = q.poll();
                int x = c[0], y = c[1];

                List<int[]> neighbors = getNeighbors(c, grid, level);
                nextLevel.addAll(neighbors);
            }

            q.addAll(nextLevel);
            level++;
        }
        
    }

    public List<int[]> getNeighbors(int[] coordinate, int[][] grid, int level){
        List<int[]> neighbors = new ArrayList<>();
        int x = coordinate[0], y = coordinate[1];

        //up
        if(x > 0 && grid[x-1][y] == 2147483647){
            int[] upNeighbor = {x-1, y};
            grid[upNeighbor[0]][upNeighbor[1]] = level;
            neighbors.add(upNeighbor);
        }

        //down
        if(x < grid.length-1 && grid[x+1][y] == 2147483647){
            int[] downNeighbor = {x+1, y};
            grid[downNeighbor[0]][downNeighbor[1]] = level;
            neighbors.add(downNeighbor);
        }

        //left
        if(y > 0 && grid[x][y-1] == 2147483647){
            int[] leftNeighbor = {x, y-1};
            grid[leftNeighbor[0]][leftNeighbor[1]] = level;
            neighbors.add(leftNeighbor);
        }

        //right
        if(y < grid[0].length-1 && grid[x][y+1] == 2147483647){
            int[] rightNeighbor = {x, y+1};
            grid[rightNeighbor[0]][rightNeighbor[1]] = level;
            neighbors.add(rightNeighbor);
        }

        return neighbors;
    }
}
