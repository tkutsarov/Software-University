/*
 * Write a Boolean method IsPrime(n) that check whether a given integer number n is prime. Examples:
n	        IsPrime(n)
0	        false
1	        false
2	        true
3	        true
4	        false
5	        true
323	        false
337	        true
6737626471	true
117342557809	false

 */

using System;

class PrimeChecker
{
    static bool IsPrime(long inputNumber)
    {
        bool isPrime = true;
        if ((inputNumber == 0) || (inputNumber == 1))
        {
            isPrime = false;
            return isPrime;
        }
        for (int i = 2; i <= Math.Sqrt(inputNumber); i++)
        {
            if (inputNumber % i == 0)
            {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    static void Main()
    {
        Console.WriteLine("Enter a number to check if it is prime:");
        long input = long.Parse(Console.ReadLine());
        Console.WriteLine("Is the entered number prime: {0}", IsPrime(input));
    }
}

