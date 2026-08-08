class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == '1'){
                    islandCount++;
                    int[] coordinate = {row, col};
                    dfs(coordinate, grid);
                }
            }
        }
        
        return islandCount;
    }

    public void dfs(int[] coordinate, char[][] grid){
        int x = coordinate[0], y = coordinate[1];
        grid[x][y] = 'x';

        List<int[]> neighborCoordinates = getNeighbors(coordinate, grid);
        if(neighborCoordinates.isEmpty()){
            return;
        }

        for(int[] n : neighborCoordinates){
            dfs(n, grid);
        }
    }

    public List<int[]> getNeighbors(int[] coordinate, char[][] grid){
        List<int[]> neighbors = new ArrayList<>();
        int x = coordinate[0], y = coordinate[1];

        //up
        if(x > 0 && grid[x-1][y] != 'x' && grid[x-1][y] != '0'){
            int[] upNeighbor = {x-1, y};
            neighbors.add(upNeighbor);
        }

        //down
        if(x < grid.length-1 && grid[x+1][y] != 'x' && grid[x+1][y] != '0'){
            int[] downNeighbor = {x+1, y};
            neighbors.add(downNeighbor);
        }

        //left
        if(y > 0 && grid[x][y-1] != 'x' && grid[x][y-1] != '0'){
            int[] leftNeighbor = {x, y-1};
            neighbors.add(leftNeighbor);
        }

        //right
        if(y < grid[0].length-1 && grid[x][y+1] != 'x' && grid[x][y+1] != '0'){
            int[] rightNeighbor = {x, y+1};
            neighbors.add(rightNeighbor);
        }

        return neighbors;
    }
}
