/*
 * Write a program that counts how many times a given word occurs in given text. The first line in the 
 * input holds the word. The second line of the input holds the text. The output should be a single 
 * integer number – the number of word occurrences. Matching should be case-insensitive. Note that not 
 * all matching substrings are words and should be counted. A word is a sequence of letters separated 
 * by punctuation or start / end of text. Examples:
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _16CountingWordInText
{
    class CountingWordInText
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the word to be searched for:");
            string searchedWord = Console.ReadLine();
            Console.WriteLine("Enter the text from which the URLs will be extracted nad press Enter twice:");
            string line = "";
            string input = "";
            while (((line = Console.ReadLine()) != null) && (line != ""))
            {
                input = input + line;
            }

            char[] separators = new char[]
                {' ', ',', '.', '!', '?', '(', ')', ':', ';', '"', '\'', '/', '\\', '*', '%','$', '+', '&', '@'};           
            int count = 0;
            List<string> wordList = new List<string>(input.Split(separators, 
                StringSplitOptions.RemoveEmptyEntries));
            foreach (var word in wordList)
            {
                if (word.ToUpper() == searchedWord.ToUpper())
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}
