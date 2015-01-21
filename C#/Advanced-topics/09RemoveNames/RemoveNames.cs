/*
 * Write a program that takes as input two lists of names and removes from the first list all names given 
 * in the second list. The input and output lists are given as words, separated by a space, each list at a 
 * separate line. Examples:
Input	                                                  Output
Peter Alex Maria Todor Steve Diana Steve
Todor Steve Nakov	                                      Peter Alex Maria Diana
Hristo Hristo Nakov Nakov Petya
Nakov Vanessa Maria	                                      Hristo Hristo Petya

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class RemoveNames
{
    static void Main()
    {
        Console.WriteLine("Enter the first list of names separated by space");
        string inputOne = Console.ReadLine();
        Console.WriteLine("Enter the second list of names separated by space");
        string inputTwo = Console.ReadLine();
        List<string> firstList = new List<string>(inputOne.Split(' '));
        List<string> secondList = new List<string>(inputTwo.Split(' '));
        
        for (int i = 0; i < firstList.Count; i++)
        {
            for (int j = 0; j < secondList.Count; j++)
            {
                if (secondList[j] == firstList[i])
                {
                    firstList.RemoveAt(i);
                    i--;
                }
            }         
        }
        for (int i = 0; i < firstList.Count; i++)
        {
            Console.Write(firstList[i] + " ");
        }
    }
}

