class Solution {
    public void islandsAndTreasure(int[][] grid) {
        List<int[]> treasures = findTreasures(grid);

        List<Queue<int[]>> queues = new ArrayList<>();

        for(int[] treasure : treasures){
            // System.out.println(treasure[0] + ", " + treasure[1]);
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(treasure);

            queues.add(q);
        }

        int level = 0, done = 0;

        //perform bfs on each one
        while(done < queues.size()){
            for(Queue<int[]> q : queues){
                if(q.isEmpty()){
                    continue;
                }

                List<int[]> nextLevel = new ArrayList<>();

                while(!q.isEmpty()){
                    int[] coordinate = q.poll();

                    if(grid[coordinate[0]][coordinate[1]] == 2147483647){
                        grid[coordinate[0]][coordinate[1]] = level;
                    }

                    List<int[]> neighbors = getValidNeighbors(coordinate, grid);
                    nextLevel.addAll(neighbors);
                }

                if(nextLevel.size() == 0){
                    done++;
                }else{
                    for(int[] c : nextLevel){
                        q.offer(c);
                    }
                }
            }

            level++;
        }  
    }

    public List<int[]> findTreasures(int[][] grid){
        List<int[]> treasures = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    int[] treasure = {i,j};
                    treasures.add(treasure);
                }
            }
        }

        return treasures;
    }

    public List<int[]> getValidNeighbors(int[] p, int[][] grid){
        List<int[]> neighbors = new ArrayList<>();
        int x = p[0], y = p[1];

        //left neighbor
        if(y > 0){
            if(grid[x][y-1] == 2147483647){
                int[] coordinate = {x, y-1};
                neighbors.add(coordinate);
            }
        }

        //right neighbor
        if(y < grid[x].length-1){
            if(grid[x][y+1] == 2147483647){
                int[] coordinate = {x, y+1};
                neighbors.add(coordinate);
            }
        }

        //top neighbor
        if(x > 0){
            if(grid[x-1][y] == 2147483647){
                int[] coordinate = {x-1, y};
                neighbors.add(coordinate);
            }
        }

        //bottom neighbor
        if(x < grid.length-1){
            if(grid[x+1][y] == 2147483647){
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
