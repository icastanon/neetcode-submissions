class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                if(board[row][column] == '.')
                    continue;
                //check for row
                Set<Character> rowSet = rowMap.get(row);
                if(Objects.isNull(rowSet)){
                    rowSet = new HashSet<>();
                    rowSet.add(board[row][column]);
                    rowMap.put(row, rowSet);
                }else if(!rowSet.contains(board[row][column])){
                    rowSet.add(board[row][column]);
                }else{
                    return false;
                }

                //check for column
                Set<Character> colSet = colMap.get(column);
                if(Objects.isNull(colSet)){
                    colSet = new HashSet<>();
                    colSet.add(board[row][column]);
                    colMap.put(column, colSet);
                }else if(!colSet.contains(board[row][column])){
                    colSet.add(board[row][column]);
                }else{
                    return false;
                }

                //check for box
                int boxIndex = (row/3) * 3 + (column/3); 
                Set<Character> boxSet = boxMap.get(boxIndex);
                if(Objects.isNull(boxSet)){
                    boxSet = new HashSet<>();
                    boxSet.add(board[row][column]);
                    boxMap.put(boxIndex, boxSet);
                }else if(!boxSet.contains(board[row][column])){
                    boxSet.add(board[row][column]);
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
