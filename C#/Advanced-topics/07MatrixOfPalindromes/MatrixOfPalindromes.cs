/*
 * Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns:
Input	Output
3 6	    aaa aba aca	ada aea afa
        bbb bcb bdb	beb bfb bgb
        ccc cec cdc	cfc cgc chc
2 3	    aaa aba aca
        bbb bcb bdb
1 1	    aaa
1 3 	aaa aba aca

*/

using System;

class MatrixOfPalindromes
{
    static void Main()
    {
        int rows = 2;
        int cols = 3;
        string[,] matrix = new string[rows, cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                matrix[i, j] = Convert.ToChar(97 + i).ToString() + Convert.ToChar(97 + j + i).ToString()
                    + Convert.ToChar(97 + i).ToString();
            }
        }
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                Console.Write( matrix[i, j] + " " );  
            }
            Console.WriteLine();
        }
    }
}

