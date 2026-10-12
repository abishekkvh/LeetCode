import java.util.*;

public class MatrixDiagonalSum
{
    public static void main(String[] args)
    {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(matrixDiagonalSum(matrix));
    }

    public static int matrixDiagonalSum(int[][] matrix)
    {
        int sum = 0, duplicate = 0;
        int n= matrix[0].length;

        for(int i = 0; i < matrix.length; i++)
        {
            if(i == n-i-1)
            {
                duplicate = matrix[i][n-i-1];
            }
            sum += matrix[i][i];
            sum += matrix[i][n-i-1];
        }

        return sum - duplicate;
    }
}
