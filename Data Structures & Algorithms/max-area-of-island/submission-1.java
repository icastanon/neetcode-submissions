class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Set<Coordinate> visited = new HashSet<>();
        int maxArea = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                int value = grid[row][col];
                Coordinate i = new Coordinate(row, col, value);
                if(!visited.contains(i) && value == 1){
                    //new island encountered
                    int area = dfs(i, grid, visited);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
        
    }

    class Coordinate{
        public int x, y;
        int value;

        public Coordinate(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Coordinate other = (Coordinate) obj;
            
            return this.x == other.x && this.y == other.y;
        }

        public int hashCode(){
            return Objects.hash(x, y);
        }
    }

    public int dfs(Coordinate c, int[][] grid, Set<Coordinate> visited){
        if(visited.contains(c)){
            return 0;
        }

        visited.add(c);

        //each coordiante will have between 0 and 4 neighbors
        List<Coordinate> neighbors = getNeighbors(c, grid);

        // System.out.println("NEIGHBORS OF " + c.x + ", " + c.y + ": ");
        // for(Coordinate x : neighbors){
        //     System.out.println(x.value);
        // }

        int area = 1;

        for(Coordinate coordinate : neighbors){
            area+=dfs(coordinate, grid, visited);
        }

        return area;

    }

    public List<Coordinate> getNeighbors(Coordinate c, int[][] grid){
        List<Coordinate> neighbors = new ArrayList<>();

        //left neighbor
        if(c.y > 0){
            if(grid[c.x][c.y-1] == 1){
                neighbors.add(new Coordinate(c.x, c.y-1, 1));
            }
        }

        //right neighbor
        if(c.y < grid[c.x].length-1){
            if(grid[c.x][c.y+1] == 1){
                neighbors.add(new Coordinate(c.x, c.y+1, 1));
            }
        }

        //top neighbor
        if(c.x > 0){
            if(grid[c.x-1][c.y] == 1){
                neighbors.add(new Coordinate(c.x-1, c.y, 1));
            }
        }

        //bottom neighbor
        if(c.x < grid.length-1){
            if(grid[c.x+1][c.y] == 1){
                neighbors.add(new Coordinate(c.x+1, c.y, 1));
            }
        }

        return neighbors;
    }
}


