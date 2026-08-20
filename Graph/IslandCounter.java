package Graph;


import java.util.LinkedList;
import java.util.Queue;

public class IslandCounter 
{
    private static final int[][] DIRECTIONS = 
    {
        {-1, 0}, 
        {1, 0},  
        {0, -1}, 
        {0, 1}   
    };

    private static final char LAND = '1';
    private static final char WATER = '0';

    public int numIslands(char[][] grid) 
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
        {
            return 0;
        }

        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int islandCount = 0;

        for (int row = 0; row < totalRows; row++) 
        {
            for (int col = 0; col < totalCols; col++) 
            {
                if (grid[row][col] == LAND) 
                {
                    islandCount++;
                    exploreIslandBFS(grid, row, col, totalRows, totalCols);
                }
            }
        }

        return islandCount;
    }

    private void exploreIslandBFS(char[][] grid, int startRow, int startCol, int totalRows, int totalCols) 
    {
        Queue<Integer> cellQueue = new LinkedList<>();
        
        cellQueue.offer(startRow * totalCols + startCol);
        grid[startRow][startCol] = WATER; 

        while (!cellQueue.isEmpty()) 
        {
            int flattenedIndex = cellQueue.poll();
            int currentRow = flattenedIndex / totalCols;
            int currentCol = flattenedIndex % totalCols;

            for (int[] direction : DIRECTIONS) 
            {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (isValidLand(grid, nextRow, nextCol, totalRows, totalCols)) 
                {
                    cellQueue.offer(nextRow * totalCols + nextCol);
                    grid[nextRow][nextCol] = WATER; 
                }
            }
        }
    }

    private boolean isValidLand(char[][] grid, int row, int col, int totalRows, int totalCols) 
    {
        return row >= 0 && row < totalRows && col >= 0 && col < totalCols && grid[row][col] == LAND;
    }

    public static void main(String[] args) 
    {
        IslandCounter solver = new IslandCounter();

        char[][] grid1 = 
        {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Test Case 1 - Expected: 1, Actual: " + solver.numIslands(grid1));

        char[][] grid2 = 
        {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Test Case 2 - Expected: 3, Actual: " + solver.numIslands(grid2));
    }
}
