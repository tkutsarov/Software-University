/*
 * Write a program that extracts and prints all URLs from given text. URL can be in only two formats:
•	http://something, e.g. http://softuni.bg, http://forums.softuni.bg, http://www.nakov.com 
•	www.something.domain, e.g. www.nakov.com, www.softuni.bg, www.google.com
Examples:
Input	Output
The site nakov.com can be access from http://nakov.com or www.nakov.com. It has subdomains like mail.nakov.com 
 * and svetlin.nakov.com. Please check http://blog.nakov.com for more information.	
 * 
http://nakov.com
www.nakov.com
http://blog.nakov.com

*/

using System;
using System.Text.RegularExpressions;

class ExtractURLs
{
    static void Main(string[] args)
    {           
        Console.WriteLine("Enter the text from which the URLs will be extracted nad press Enter twice:");
        string line = "";
        string input = "";
        while (((line = Console.ReadLine()) != null) && (line != ""))
        {
            input = input + line;
        }

        Regex urlExtractor = new Regex(@"\b(?:https?://|www\.)\S+\b",
            RegexOptions.Compiled | RegexOptions.IgnoreCase);
        foreach (Match m in urlExtractor.Matches(input))
        {
            Console.WriteLine(m);
        }              
    }
}

