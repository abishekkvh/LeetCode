import java.util.*;

public class TransposeMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] transposedMatrix = transposeMatrix(matrix);

        for(int i = 0; i < transposedMatrix.length; i++)
        {
            for(int j = 0; j < transposedMatrix[0].length; j++)
            {
                System.out.print(transposedMatrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static int[][] transposeMatrix(int[][] matrix)
    {

        int[][] transpose = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }
}
