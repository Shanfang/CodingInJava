public class SearchMatrixIte{
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if (matrix == null || matrix.length == 0) {
            return false;
        }


        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;


    // iterative approach
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
       
            if (target == matrix[start / n][start % n] || target == matrix[end / n][end % n]) {
                return true;
            }
      

        return false;
    } 
      
    public static void main(String[] args) {
        SearchMatrixIte searchM = new SearchMatrixIte();
        int[][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = new int[][]{null};
        int target = 11;
        boolean result = searchM.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
