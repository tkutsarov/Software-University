/*
 * Write a program that enters two dates in format dd.MM.yyyy and returns the number of days between them. 
 * Examples:
First date
Second date	Days between
17.03.2014
30.04.2014	44
17.03.2014
17.03.2014	0
14.06.1980
5.03.2014	12317
5.03.2014
3.03.2014	-2

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04DifferenceBetweenDates
{
    class DifferenceBetweenDates
    {
        static long CalculateDateDifference(DateTime beginning, DateTime end)
        {
            long dateDifferenceDays = (long)(end - beginning).TotalDays;
            return dateDifferenceDays;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Enter staring date dd.mm.yyyy:");
            DateTime startDate = DateTime.Parse(Console.ReadLine());
            Console.WriteLine("Enter end date dd.mm.yyyy:");
            DateTime endDate = DateTime.Parse(Console.ReadLine());
            Console.WriteLine("The difference is {0} days", CalculateDateDifference(startDate, endDate));
        }
    }
}
