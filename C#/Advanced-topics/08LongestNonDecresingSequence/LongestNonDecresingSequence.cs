/*
 * Write a program that reads a sequence of integers and finds in it the longest non-decreasing subsequence. 
 * In other words, you should remove a minimal number of numbers from the starting sequence, so that the 
 * resulting sequence is non-decreasing. In case of several longest non-decreasing sequences, print the 
 * leftmost of them. The input and output should consist of a single line, holding integer numbers separated 
 * by a space. 
 * Examples:
Input	                                Output
1	                                    1
7 3 5 8 -1 6 7	                        3 5 6 7
1 1 1 2 2 2         	                1 1 1
1 1 1 3 3 3 2 2 2 2 	                2 2 2 2
11 12 13 3 14 4 15 5 6 7 8 7 16 9 8 	3 4 5 6 7 8 9

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08LongestNonDecresingSequence
{
    class LongestNonDecresingSequence
    {
        static void Main()
        {
            // NOT READY YET, won't calculate if the next members are higher than t-1 but lower than t and so on!
            /* Sth is wrong with that problem!!! 
             * Input 1 1 1 2 2 2 gives Output 1 1 1, but all of the input 1 1 1 2 2 2 is non- decreasing
             * sequence, why the output is just 1 1 1
             * Input 1 1 1 3 3 3 2 2 2 2 gives output 2 2 2 2 ?WHY? 1 1 1 3 3 3 is a non-decreasing sequence and
             * is longer than 2 2 2 2
             * Something may be missing from the definition of the problem or whatever.
            */
            Console.WriteLine("Enter an array of integers, each one separated by a single space /5 8 13 2 5/:");
            string input = Console.ReadLine();
            List<int> inputList = new List<int>(Array.ConvertAll(input.Split(' '), int.Parse));
            List<int> longestSubsequence = new List<int>();
            List<int> buffer = new List<int>();
            int count = 1;
            
            for (int i = 0; i < inputList.Count; i++)
            {
                if (i < inputList.Count - 1)
                {
                    buffer.Add(inputList[i]);
                    for (int j = i + 1; j < inputList.Count; j++)
                    {
                        if (inputList[j] >= buffer[buffer.Count - 1])
                        {
                            count++;
                            buffer.Add(inputList[j]);
                            if (j == inputList.Count - 1)
                            {
                                if (count > longestSubsequence.Count)
                                {                                   
                                    longestSubsequence.Clear();
                                    longestSubsequence = buffer.ToList();                                                        
                                }     
                            }
                        }
                        else
                        {
                            if (count > longestSubsequence.Count)
                            {                                
                                longestSubsequence.Clear();
                                longestSubsequence = buffer.ToList();                                                        
                            }                           
                        }
                    }
                }
                else
                {
                    if (inputList[i] >= longestSubsequence[longestSubsequence.Count - 1])
                    {
                        count++;
                        buffer.Add(inputList[i]);
                        if (count > longestSubsequence.Count)
                        {                           
                            longestSubsequence.Add(inputList[i]);                           
                        }
                    }
                }
                buffer.Clear();
                count = 1;
            }

            foreach (var item in longestSubsequence)
            {
                Console.Write(item);
            }
        }			
    }
}
