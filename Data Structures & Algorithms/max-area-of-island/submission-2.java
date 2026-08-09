class Solution {
    class Coordinate{
        int row, col, val;

        public Coordinate(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public boolean equals(Object other){
            Coordinate casted = (Coordinate) other;
            return this.row == casted.row && this.col == casted.col && this.val == casted.val;
        }

        public int hashCode(){
            return Objects.hash(this.row, this.col, this.val);
        }
    }

    int area = 0;
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        Set<Coordinate> visited = new HashSet<>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                Coordinate coor = new Coordinate(row, col, grid[row][col]);
                if(grid[row][col] == 1 && !visited.contains(coor)){
                    area = 0;
                    dfs(coor, grid, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public void dfs(Coordinate c, int[][] grid, Set<Coordinate> visited){
        List<Coordinate> neighbors = getNeighbors(c, grid);
        visited.add(c);
        area++;

        for(Coordinate n : neighbors){
            if(!visited.contains(n))
                dfs(n, grid, visited);
        }
    }

    

    public List<Coordinate> getNeighbors(Coordinate c, int[][] grid){
        List<Coordinate> neighbors = new ArrayList<>();

        //up
        if(c.row > 0 && grid[c.row-1][c.col] == 1){
            neighbors.add(new Coordinate(c.row-1, c.col, 1));
        }

        //down
        if(c.row < grid.length-1 && grid[c.row+1][c.col] == 1){
            neighbors.add(new Coordinate(c.row+1, c.col, 1));
        }

        //left
        if(c.col > 0 && grid[c.row][c.col-1] == 1){
            neighbors.add(new Coordinate(c.row, c.col-1, 1));
        }

        //right
        if(c.col < grid[c.row].length-1 && grid[c.row][c.col+1] == 1){
            neighbors.add(new Coordinate(c.row, c.col+1, 1));
        }

        return neighbors;
    }
}
