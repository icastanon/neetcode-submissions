class Solution {
    public void solve(char[][] board) {
        List<int[]> borderZeros = new ArrayList<>();
        //get all on the bottom border
        for(int i = 0; i < board[0].length; i++){
            int lastRow = board.length-1;
            int[] coordinate = {lastRow, i};
            
            if(board[coordinate[0]][coordinate[1]] == 'O'){
                borderZeros.add(coordinate);
            }
        }

        //get all on the right border
        for(int i = 0; i < board.length-1; i++){
            int lastCol = board[i].length-1;
            int[] coordinate = {i, lastCol};
            if(board[coordinate[0]][coordinate[1]] == 'O'){
                borderZeros.add(coordinate);
            }
        }

        //get all on the left border
        for(int i = 0; i < board.length; i++){
            int firstCol = 0;
            int[] coordinate = {i, firstCol};
            if(board[coordinate[0]][coordinate[1]] == 'O'){
                borderZeros.add(coordinate);
            }
        }

        //get all on the top border
        for(int i = 1; i < board[0].length; i++){
            int firstRow = 0;
            int[] coordinate = {firstRow, i};
            if(board[coordinate[0]][coordinate[1]] == 'O'){
                borderZeros.add(coordinate);
            }
        }


        //run dfs on atlantic borders
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int[] coordinate : borderZeros){
            if(!visited[coordinate[0]][coordinate[1]]){
                dfs(coordinate, board, visited);
            }
        }

        //find unvisited 0s
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }

    public void dfs(int[] coordinate, char[][] heights, boolean[][] visited){
        if(visited[coordinate[0]][coordinate[1]]){
            return;
        }

        visited[coordinate[0]][coordinate[1]] = true;

        List<int[]> neighbors = getNeighbors(coordinate, heights, visited);

        for(int[] neighbor : neighbors){
            dfs(neighbor, heights, visited);
        }

    }

    public List<int[]> getNeighbors(int[] p, char[][] grid, boolean[][] visited){
        List<int[]> neighbors = new ArrayList<>();
        int x = p[0], y = p[1];

        //left neighbor
        if(y > 0){
            if(!visited[x][y-1] && grid[x][y-1] == 'O'){
                int[] coordinate = {x, y-1};
                neighbors.add(coordinate);
            }
        }

        //right neighbor
        if(y < grid[x].length-1){
            if(!visited[x][y+1] && grid[x][y+1] == 'O'){
                int[] coordinate = {x, y+1};
                neighbors.add(coordinate);
            }
        }

        //top neighbor
        if(x > 0){
            if(!visited[x-1][y] && grid[x-1][y] == 'O'){
                int[] coordinate = {x-1, y};
                neighbors.add(coordinate);
            }
        }

        //bottom neighbor
        if(x < grid.length-1){
            if(!visited[x+1][y] && grid[x+1][y] == 'O'){
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
