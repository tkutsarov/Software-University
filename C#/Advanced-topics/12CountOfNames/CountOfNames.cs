/*
 * Write a program that reads a list of names and prints for each name how many times it appears in the list. The names should be listed in alphabetical order. Use the input and output format from the examples below. Examples:
Input	                                    Output
Peter Steve Nakov Steve Alex Nakov	        Alex -> 1
                                            Nakov -> 2
                                            Peter -> 1
                                            Steve -> 2
Nakov Nakov Nakov SoftUni Nakov	            SoftUni -> 1
                                            Nakov -> 5

*/

using System;
using System.Collections.Generic;
using System.Linq;

class CountOfNames
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter the array of names separated by a single space:");
        string input = Console.ReadLine();
        List<string> inputNames = new List<string>(input.Split(' ').ToArray());
        bool isAdded = false;
        SortedDictionary<string, int> result = new SortedDictionary<string, int>();

        for (int i = 0; i < inputNames.Count; i++)
        {
            foreach (var item in result)
            {
                if (item.Key == inputNames[i])
                {
                    result[item.Key]++;
                    isAdded = true;
                    break;
                }
            }
            if (isAdded == false)
            {
                result.Add(inputNames[i], 1);
            }
            isAdded = false;
        }

        foreach (var item in result)
        {
            Console.WriteLine("{0} -> {1}", item.Key, item.Value);
        }
    }
}

