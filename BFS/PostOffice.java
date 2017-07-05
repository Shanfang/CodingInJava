import java.util.*;
/* 
This version works for the following scenario:
we can get from one house to another house

EMPTY   HOUSE   HOUSE   WALL    EMPTY
            ---> 
*/
public class PostOffice {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public class ReturnType {
        boolean valid = false;
        int sum = Integer.MAX_VALUE;
        ReturnType(boolean status, int num) {
            this.valid = status; 
            this.sum = num;
        }
    }
    
    public class Coordinate {
        int row;
        int col;
        Coordinate(int x, int y) {
            this.row = x; 
            this.col = y;
        }
    }
    
    int[] rowOffset = {-1, 0, 0 , 1};
    int[] colOffset = {0, 1, -1,  0};
    int EMPTY = 0;
    int HOUSE = 1;
    int WALL = 2;
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // do BFS and check if it is possible to visit every house
        // calculate sum of distance
        
        // loop through the grid for every empty spot, update disSum
        int row = grid.length;
        int col = grid[0].length;

        
        // count the number of houses in the grid
        int house = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == HOUSE) {
                    house++;
                }
            }
        }
        System.out.println("There are such many houses: " + house);

        int minDist = Integer.MAX_VALUE;
        ReturnType result = new ReturnType(false, Integer.MAX_VALUE);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    //System.out.println("There is an empty space");
                    boolean[][] visited = new boolean[row][col];
                    for (int m = 0; m < row; m++) {
                        for (int n = 0; n < col; n++) {
                            visited[m][n] = false;
                        }
                    }
                    result = sumDistance(grid, i, j, visited, house);
                }
                if (result.valid) {
                    minDist = result.sum < minDist ? result.sum : minDist; 
                    //System.out.println("Here is the postion of post office: [" + i + ", " + j + "]" );
                }
            }
        }
        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }
        return minDist;
    }
    
    
    private ReturnType sumDistance(int[][] grid, int row, int col, boolean[][] visited, int house) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(row, col));
        int sum = 0;
        System.out.println("Calculating distance using BFS");  
        int layer = 0; 
        while (!queue.isEmpty()) {
            layer++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Coordinate head = queue.poll();

                for (int i = 0; i < 4; i++) {
                    Coordinate position = new Coordinate(head.row + rowOffset[i], head.col + colOffset[i]);
                    if (!inBound(grid, position)) {
                       continue; 
                    }
                    
                    if (!visited[position.row][position.col] &&
                        grid[position.row][position.col] != WALL) {
                        if (grid[position.row][position.col] == HOUSE) {
                            house--;
                            sum += layer;
                            //System.out.println("Finding one house");
                        }
                        queue.offer(position);
                        visited[position.row][position.col] = true;
                    }
                }
            }
     
        }
        if (house != 0) {
            return new ReturnType(false, Integer.MAX_VALUE);
        }
        System.out.println("In BFS, current sum of distance is: " + sum);
        return new ReturnType(true, sum);
    }
    
    private boolean inBound(int[][] grid, Coordinate position) {
        if (position.row < 0 || position.row >= grid.length) {
            return false;
        }
        if (position.col < 0 || position.col >= grid[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PostOffice ps = new PostOffice();
        //int[][] grid = {{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}};
        int[][] grid = {{0,1,0,0},{1,0,2,1},{0,1,0,0}};
        int distance = ps.shortestDistance(grid);
        System.out.println("Shortest distance is: " + distance);
    }
}