/*
 * Define a method Fib(n) that calculates the nth Fibonacci number. Examples:
n	Fib(n)
0	1
1	1
2	2
3	3
4	5
5	8
6	13
11	144
25	121393

*/

using System;

class FibonacciNumbers
{
    // There is a formula for that so that you can avoid calculating all the fibonacci numbers:
    // http://www.askamathematician.com/2011/04/q-is-there-a-formula-to-find-the-nth-term-in-the-fibonacci-sequence/
    static long FindFiboNumber(int fibNumber)        
    {
        double resultDouble = 0;
        resultDouble = (1 / Math.Sqrt(5)) * Math.Pow((1 + Math.Sqrt(5))/2, fibNumber + 1);
        long result = (long)resultDouble;
        return result;
    }
    static void Main()
    {
        Console.WriteLine("Enter the fibonacci number you want to be displayed");
        int fibNumber = int.Parse(Console.ReadLine());
        Console.WriteLine("Fibonacci number N {0} is: {1}", fibNumber, FindFiboNumber(fibNumber));
    }
}

