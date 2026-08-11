class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean noFreshFruit = true;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 2){
                    int[] coordinate = {row, col};
                    q.offer(coordinate);
                }else if(grid[row][col] == 1){
                    noFreshFruit = false;
                }
            }
        }

        System.out.println(q.isEmpty());

        if(noFreshFruit)
            return 0;
        else if(q.isEmpty())
            return -1;

        int level = 0;

        while(!q.isEmpty()){
            level++;
            //list of all fresh fruit neighbors across all rotting
            List<int[]> nextLevel = new ArrayList<>();

            while(!q.isEmpty()){
                int[] c = q.poll();

                List<int[]> neighbors = getNeighbors(c, grid);
                nextLevel.addAll(neighbors);
            }

            q.addAll(nextLevel);
            // System.out.println(nextLevel.size() + " fruit rotted at minute " + level);
            
        }

        for(int[] col : grid){
            for(int fruit : col){
                if(fruit == 1)
                    return -1;
            }
        }

        return level-1;
        
    }

    public List<int[]> getNeighbors(int[] coordinate, int[][] grid){
        List<int[]> neighbors = new ArrayList<>();
        int x = coordinate[0], y = coordinate[1];

        //up
        if(x > 0 && grid[x-1][y] == 1){
            int[] upNeighbor = {x-1, y};
            grid[upNeighbor[0]][upNeighbor[1]] = 2;
            neighbors.add(upNeighbor);
        }

        //down
        if(x < grid.length-1 && grid[x+1][y] == 1){
            int[] downNeighbor = {x+1, y};
            grid[downNeighbor[0]][downNeighbor[1]] = 2;
            neighbors.add(downNeighbor);
        }

        //left
        if(y > 0 && grid[x][y-1] == 1){
            int[] leftNeighbor = {x, y-1};
            grid[leftNeighbor[0]][leftNeighbor[1]] = 2;
            neighbors.add(leftNeighbor);
        }

        //right
        if(y < grid[0].length-1 && grid[x][y+1] == 1){
            int[] rightNeighbor = {x, y+1};
            grid[rightNeighbor[0]][rightNeighbor[1]] = 2;
            neighbors.add(rightNeighbor);
        }

        return neighbors;
    }
}
