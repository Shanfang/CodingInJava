import java.util.*;

public class KthSmall {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    class Node {
        int row;
        int col;
        int val;
        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    int[] rOffset = new int[]{0, 1};
    int[] cOffset = new int[]{1, 0};
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MAX_VALUE;
        }
        
        Queue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        minHeap.offer(new Node(0, 0, matrix[0][0]));
        
        boolean[][] trace = new boolean[matrix.length][matrix[0].length];
        
        for (int j = 0; j < k - 1; j++) {
            Node node = minHeap.poll();
            for (int i = 0; i < 2; i++) {
                int newRow = node.row + rOffset[i];
                int newCol = node.col + cOffset[i];
                if (!inBound(matrix, newRow, newCol)) {
                    continue;
                }
                if(!trace[newRow][newCol]) {
                    Node nextNode = new Node(newRow, newCol, matrix[newRow][newCol]);
                    minHeap.offer(nextNode);
                    trace[newRow][newCol] = true;
                }
            }
        }
        return minHeap.peek().val;
    }
    
    private boolean inBound(int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KthSmall small = new KthSmall();
        int[][] matrix = new int[][]{{1,5,7},{3,7,8},{4,8,9}};
        int result = small.kthSmallest(matrix, 6);
        System.out.println(result);
    }
}