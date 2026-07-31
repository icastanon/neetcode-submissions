class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //do binary search to find the row
        int rowNum = outerBinSearch(matrix, target);

        //do binary search on the row
        if(rowNum >= 0){
            int[] row = matrix[rowNum];
            int start = 0, end = row.length-1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(row[mid] == target){
                    return true;
                }else if(row[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }

        return false;
        
    }

    public int outerBinSearch(int[][] matrix, int target){
        int start = 0, end = matrix.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target){
                return mid;
            }else if(matrix[mid][0] > target){
                end = mid - 1;
            }else if(matrix[mid][matrix[mid].length-1] < target){
                start = mid + 1;
            }
        }
        return -1;
    }
}
