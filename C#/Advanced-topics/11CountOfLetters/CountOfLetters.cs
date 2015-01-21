/*
 * Write a program that reads a list of letters and prints for each letter how many times it appears 
 * in the list. The letters should be listed in alphabetical order. Use the input and output format 
 * from the examples below. Examples:
Input	                                        Output
b b a a b	                                    a -> 2
                                                b -> 3
h d h a a a s d f d a d j d s h a a	            a -> 6
                                                d -> 5
                                                f -> 1
                                                h -> 3
                                                j -> 1
                                                s -> 2

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class CountOfLetters
{
    static void Main()
    {
        Console.WriteLine("Enter the array of letters separated by a single space:");
        string input = Console.ReadLine();
        List<char> inputLetters = new List<char>(Array.ConvertAll(input.Split(' '), char.Parse));
        bool isAdded = false;        
        SortedDictionary<char, int> result = new SortedDictionary<char, int>();

        for (int i = 0; i < inputLetters.Count; i++)
        {
            foreach (var item in result)
            {
                if (item.Key == inputLetters[i])
                {
                    result[item.Key]++;
                    isAdded = true;
                    break;
                }                
            }
            if (isAdded == false)
            {
                result.Add(inputLetters[i], 1);               
            }
            isAdded = false;
        }
        
        foreach (var item in result)
        {
            Console.WriteLine("{0} -> {1}", item.Key, item.Value);
        }
    }
}

