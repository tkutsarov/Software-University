/*
 * Write a program to find the longest word in a text. Examples:
Input	                                                                               Output
Welcome to the Software University.	                                                   University
The C# Basics course is awesome start in programming with C# and Visual Studio.	       programming

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class LongestWord
{
    static void Main()
    {
        Console.WriteLine("Enter the data and when finished press Enter twice:");
        // copy paste into the console from the problem examples
        string input = "";
        string line = "";
        char[] separators = new char[]{' ', ',', '.', '!', '?', '(', ')', ':', ';'};
        while (((line = Console.ReadLine()) != null) && (line != ""))
        {
            input = input + line;
        }

        List<string> result = new List<string>(input.Split(separators, StringSplitOptions.RemoveEmptyEntries));
        int longest = result[0].Length;        
        string longestWord = result[0];
        for (int i = 0; i < result.Count; i++)
        {
            if (longest < result[i].Length)
            {
                longest = result[i].Length;
                longestWord = result[i];
            }
        }
        Console.WriteLine(longestWord);
    }
}

