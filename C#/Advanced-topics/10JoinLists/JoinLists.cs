/*
 * Write a program that takes as input two lists of integers and joins them. The result should hold all 
 * numbers from the first list, and all numbers from the second list, without repeating numbers, and arranged in increasing order. The input and output lists are given as integers, separated by a space, each list at a separate line. Examples:
Input	                Output
20 40 10 10 30 80
25 20 40 30 10	        10 20 25 30 40 80
5 4 3 2 1
6 3 2	               1 2 3 4 5 6
1
1	                   1

*/
using System;
using System.Collections.Generic;


class JoinLists
{
    static void Main()
    {
        Console.WriteLine("Enter the first list of numbers separated by space");
        string inputOne = Console.ReadLine();
        Console.WriteLine("Enter the second list of numbers separated by space");
        string inputTwo = Console.ReadLine();
        List<int> firstList = new List<int>(Array.ConvertAll(inputOne.Split(' '), int.Parse));
        List<int> secondList = new List<int>(Array.ConvertAll(inputTwo.Split(' '), int.Parse));

        firstList.AddRange(secondList);
        firstList.Sort();
        for (int i = 1; i < firstList.Count; i++)
        {
            if (firstList[i] == firstList[i - 1])
            {
                firstList.RemoveAt(i);
                i--;
            }
        }
        foreach (var item in firstList)
        {
            Console.Write(item + " ");
        }
    }
}

