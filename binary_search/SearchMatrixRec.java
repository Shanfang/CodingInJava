public class SearchMatrixRec {
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

        boolean result = binarySearch (matrix, 0, (m * n - 1), target);
        return result;
    }
    
    private boolean binarySearch (int[][] matrix, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        int n = matrix[0].length;
        int row = mid / n;
        int col = mid % n;

        if (target == matrix[row][col]) {
            return true;
        }
        
        // recursively find target in sub array
        if (target < matrix[row][col]) {
            return binarySearch(matrix, start, mid - 1, target);
        }
        else {
            return binarySearch(matrix, mid + 1, end, target);
        } 
    }

    public static void main(String[] args) {
        SearchMatrixRec searchM = new SearchMatrixRec();
        //int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][]{null};
        int target = 1;
        boolean result = searchM.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
