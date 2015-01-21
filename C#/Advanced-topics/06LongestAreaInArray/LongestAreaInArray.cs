/*
 * Write a program to find the longest area of equal elements in array of strings. You first should read an integer n and n strings (each at a separate line), then find and print the longest sequence of equal elements (first its length, then its elements). If multiple sequences have the same maximal length, print the leftmost of them. Examples:
Input	Output
6
hi
hi
hello
ok
ok
ok	   3
       ok
       ok
       ok
2
SoftUni
Hello	   1
           SoftUni
4
hi
hi
hi
hi	      4
        hi
        hi
        hi
        hi
5
wow
hi
hi
ok
ok	      2
          hi
          hi

*/

using System;


class LongestAreaInArray
{
    static void Main()
    {
        Console.WriteLine("Enter the quantity of the sequence:");
        int n = int.Parse(Console.ReadLine());
        Console.WriteLine("Enter the strings, each on a separate line:");
        string[] unsortedInput = new string[n];
        for (int i = 0; i < n; i++)
        {
            unsortedInput[i] = Console.ReadLine();
        }
        
        int count = 1;
        int longest = 1;
        string longestStrSequence = unsortedInput[0];
        for (int i = 1; i < unsortedInput.Length; i++)
        {
            if (unsortedInput[i] == unsortedInput[i-1]) 
            {
                count++;
            }
            else
            {
                if (count > longest)
                {
                    longest = count;
                    longestStrSequence = unsortedInput[i - 1];                 
                }
                count = 1;
            }
            if (i == unsortedInput.Length - 1)
            {
                if (count > longest)
                {
                    longest = count;
                    longestStrSequence = unsortedInput[i];
                }             
            }
        }
        for (int i = 1; i <= longest; i++)
        {
            Console.WriteLine(longestStrSequence);
        }
    }
}

