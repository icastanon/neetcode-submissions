class Solution {
    public int orangesRotting(int[][] grid) {
        int freshFruitCount = 0;

        //look for first rottens
        List<int[]> rottens = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int value = grid[i][j];
                if(value == 2){
                    int[] rotten = {i, j};
                    rottens.add(rotten);
                }else if(value == 1){
                    freshFruitCount++;
                }
            }
        }

        if(freshFruitCount == 0){
            return 0;
        }

        //add all rottens into a queue
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] rotten : rottens){
            q.offer(rotten);
            // System.out.println(rotten[0] + ", " + rotten[1]);
        }

        int result = 0;

        //perform bfs
        while(!q.isEmpty()){
            int[] coordinate = q.poll();
            int newVal = grid[coordinate[0]][coordinate[1]] + 1;

            List<int[]> neighbors = getNeighbors(coordinate, grid);

            for(int[] neighbor : neighbors){
                int x = neighbor[0], y = neighbor[1];
                if(grid[x][y] > 2)
                    continue;

                result = Math.max(newVal, result);
                grid[x][y] = newVal;
                freshFruitCount--;
                q.offer(neighbor);
            }
        }

        return freshFruitCount > 0 ? -1 : result-2;
    }

    public List<int[]> getNeighbors(int[] p, int[][] grid){
        List<int[]> neighbors = new ArrayList<>();
        int x = p[0], y = p[1];

        //left neighbor
        if(y > 0){
            if(grid[x][y-1] == 1){
                int[] coordinate = {x, y-1};
                neighbors.add(coordinate);
            }
        }

        //right neighbor
        if(y < grid[x].length-1){
            if(grid[x][y+1] == 1){
                int[] coordinate = {x, y+1};
                neighbors.add(coordinate);
            }
        }

        //top neighbor
        if(x > 0){
            if(grid[x-1][y] == 1){
                int[] coordinate = {x-1, y};
                neighbors.add(coordinate);
            }
        }

        //bottom neighbor
        if(x < grid.length-1){
            if(grid[x+1][y] == 1){
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
