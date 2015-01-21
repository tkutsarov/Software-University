/*
 * Write a program that reads a number n and a sequence of n integers, sorts them and prints them. Examples:
Input	Output
5
3
-3
2
122
0	    -3
         0
         2
         3
         122
3
0
1
0	      0
          0
          1
*/

using System;

class SortingNumbers
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter the quantity of the sequence:");
        int n = int.Parse(Console.ReadLine());
        Console.WriteLine("Enter the numbers, each on a separate line:");
        int[] unsortedInput = new int[n];
        for (int i = 0; i < n; i++)
        {
            unsortedInput[i] = int.Parse(Console.ReadLine());
        }
        Array.Sort(unsortedInput);
        Console.WriteLine("Sorted:");
        for (int i = 0; i < unsortedInput.Length; i++)
        {
            Console.WriteLine(unsortedInput[i]);
        }
    }
}

