class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] columns = new Set[9];
        Set<Character>[] rows = new Set[9];
        Set<Character>[] squares = new Set[9];

        //initialize sets
        for(int i = 0; i < columns.length; i++){
            columns[i] = new HashSet<>();
            rows[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char val = board[row][col];
                if(val != '.'){
                    if(rows[row].contains(val)){
                        return false;
                    }

                    rows[row].add(val);

                    if(columns[col].contains(val)){
                        return false;
                    }

                    columns[col].add(val);

                    int sqIndex = ((row/3)*3) + (col/3);
                    System.out.println("Square index of " + val + ": " + sqIndex);
                    if(squares[sqIndex].contains(val)){
                        return false;
                    }

                    squares[sqIndex].add(val);
                }
            }
        }

        return true;
        
    }
}
