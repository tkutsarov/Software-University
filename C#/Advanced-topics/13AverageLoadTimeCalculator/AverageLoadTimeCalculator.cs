/*
 * We have a report that holds dates, web site URLs and load times (in seconds) in the same format 
 * like in the examples below. Your tasks is to calculate the average load time for each URL. Print
 * the URLs in the same order as they first appear in the input report. Print the output in the format 
 * given below. Use double floating-point precision. Examples:
 * Input	                                        Output
2014-Mar-02 11:33 http://softuni.bg 8.37725
2014-Mar-02 11:34 http://www.google.com 1.335
2014-Mar-03 21:03 http://softuni.bg 7.25
2014-Mar-03 22:00 http://www.google.com 2.44
2014-Mar-03 22:01 http://www.google.com 2.45
2014-Mar-03 22:01 http://www.google.com 2.77
                                                    http://softuni.bg -> 7.813625
                                                    http://www.google.com -> 2.24875
2014-Apr-01 02:01 http://softuni.bg 8.37725
2014-Apr-01 02:05 http://www.nakov.com 11.622
2014-Apr-01 02:06 http://softuni.bg 4.33
2014-Apr-01 02:11 http://www.google.com 1.94
2014-Apr-01 02:11 http://www.google.com 2.011
2014-Apr-01 02:12 http://www.google.com 4.882
2014-Apr-01 02:34 http://softuni.bg 4.885
2014-Apr-01 02:36 http://www.nakov.com 10.74
2014-Apr-01 02:36 http://www.nakov.com 11.75
2014-Apr-01 02:38 http://softuni.bg 3.886
2014-Apr-01 02:44 http://www.google.com 1.04
2014-Apr-01 02:48 http://www.google.com 1.4555
2014-Apr-01 02:55 http://www.google.com 1.977
                                                    http://softuni.bg -> 5.3695625
                                                    http://www.nakov.com -> 11.3706666666667
                                                    http://www.google.com -> 2.21758333333333

*/

using System;
using System.Globalization;
using System.Collections.Generic;
using System.Threading;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class AverageLoadTimeCalculator
{
    static void Main()
    {
        Console.WriteLine("Enter the data and when finished press F6 or Ctrl^Zand Enter :");  
        // Copy paste into the console from the problem examples
        string input = "";
        List<string> inputLines = new List<string>();
        List<string> result = new List<string>();
        CultureInfo invC = CultureInfo.InvariantCulture;
        while ((input = Console.ReadLine()) != null)
        {
            inputLines.Add(input);
        }
        Dictionary<string, double> averageCalcDIctionary = new Dictionary<string, double>();
        // Change the culture to be able to parse double with point insted of comma
        Thread.CurrentThread.CurrentCulture = invC;
        // Make a list the even elements of which are the web sites and the odd elements the loading time
        foreach (var item in inputLines)
        {
            List<string> line = new List<string>(item.Split(' ').ToArray());
            result.Add(line[2]);
            result.Add(line[3]);
        }    
        // Enter the sites as unique keys and the average loading times as their values in a dictionary                              
        double sum = 0;
        int count = 1;
        for (int i = 0; i < result.Count - 3; i+= 2)
        {
            sum = Convert.ToDouble(result[i + 1]);               
            for (int j = i + 2; j < result.Count - 1; j+= 2)
            {
                if (result[j] == result[i])
                {
                    sum += Convert.ToDouble(result[j + 1]);
                    result.RemoveRange(j, 2); // remove the already calculated loading time and site
                    count++;
                    j -= 2;  // the elements in the list shift left after the removal so j has to be reversed
                }
            }
            averageCalcDIctionary.Add(result[i], sum/count);
            count = 1;
            result.RemoveRange(i, 2);
            i -= 2; // same as j
        }

        foreach (var item in averageCalcDIctionary)
        {
            Console.WriteLine("{0} -> {1}", item.Key, item.Value);
        }
           
    }
}

