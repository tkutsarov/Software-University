/*
 * Implement the "Falling Rocks" game in the text console. A small dwarf stays at the bottom of the screen 
 * and can move left and right (by the arrows keys). A number of rocks of different sizes and forms constantly 
 * fall down and you need to avoid a crash.
 * Rocks are the symbols ^, @, *, &, +, %, $, #, !, ., ;, - distributed with appropriate density. 
 * The dwarf is (O). Ensure a constant game speed by Thread.Sleep(150).
 * Implement collision detection and scoring system.
*/

using System;
using System.Collections.Generic;

struct Position
{
    public int posX;
    public int posY;
    public char rockShape;
    public ConsoleColor rockColor;
}

class FallingRocksGame
{
    public static int dwarfPosition = (Console.WindowWidth / 2) - 1;
    public static int playerScore = 0;
    public static Random rocksColor = new Random();

    private static void DrawDwarf()
    {
        Console.SetCursorPosition(dwarfPosition, 27);
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.Write("(0)");    
    }

    private static ConsoleColor GetRandomConsoleColor()
    {
        var consoleColors = Enum.GetValues(typeof(ConsoleColor));
        return (ConsoleColor)consoleColors.GetValue(rocksColor.Next(consoleColors.Length));
    }
    
    private static void PrintAtPosition(int x, int y, char symbol, ConsoleColor color)
    {
        Console.SetCursorPosition(x, y);
        Console.ForegroundColor = color;
        Console.Write(symbol);
    }

    private static void ScoreBoard(int score)
    {
        Console.SetCursorPosition(Console.WindowWidth / 2 - 4, 0);
        Console.ForegroundColor = ConsoleColor.Green;
        Console.Write("Score: {0}", playerScore);
    }

    static void Main()
    {
        bool collision = false;
        byte maxNumberOfRocks = 3;
        string rocksSymbol = "^@*&+%$#!.;";
        Random rocksPosX = new Random();
        Random numberOfRocks = new Random();
        Random rocksGroup = new Random();  
        List<Position> rocksList = new List<Position>();
        Position singleRock = new Position();

        Console.CursorVisible = false;
        Console.WindowHeight = 30;
        Console.BufferHeight = 30;
               
        while (collision == false)
        {
            Console.Clear();
            DrawDwarf();
            ScoreBoard(playerScore);
            
            // generate a new horizontal line with random number of rocks 
            int rocksFirstRow = numberOfRocks.Next(1, maxNumberOfRocks);          
            for (int i = 0; i < rocksFirstRow; i++)
            {
                // randomize the position of the new rock in the line
                singleRock.posX = rocksPosX.Next(0, Console.WindowWidth);                
                singleRock.posY = 2;
                int index = rocksPosX.Next(rocksSymbol.Length);
                singleRock.rockShape = rocksSymbol[index];
                singleRock.rockColor = GetRandomConsoleColor();
                // remove the if to have a ninja rocks with black color blending with the background
                if (singleRock.rockColor == ConsoleColor.Black)
                {
                    singleRock.rockColor = ConsoleColor.Blue;
                }
                // end
                rocksList.Add(singleRock);
                //make groups of two or three rocks
                int rockGroupSequence = rocksGroup.Next(1, 8);
                if ((rockGroupSequence == 2) && (singleRock.posX < Console.WindowWidth - 1))
                {
                    singleRock.posX++;
                    rocksList.Add(singleRock);
                }
                else if ((rockGroupSequence == 3) && (singleRock.posX < Console.WindowWidth - 2))
                {
                    singleRock.posX++;
                    rocksList.Add(singleRock);
                    singleRock.posX++;
                    rocksList.Add(singleRock);
                }
            }

            for (int j = 0; j < rocksList.Count; j++)
            {
                 
                PrintAtPosition(rocksList[j].posX, rocksList[j].posY, rocksList[j].rockShape,
                    rocksList[j].rockColor);
                // collision detection /the dwarf has tree chars/ and final score
                if (((rocksList[j].posX == dwarfPosition) || (rocksList[j].posX == dwarfPosition + 1) ||
                    (rocksList[j].posX == dwarfPosition + 2)) && (rocksList[j].posY == 27))
                {
                    Console.Clear();
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("Game Over!");
                    Console.WriteLine("Score: {0}", playerScore);                                       
                    collision = true;
                    break;
                }                          
                // Print only if the bottom line hasn't been reached anf if so increase the posY for the 
                // next drawing cycle                
                if (rocksList[j].posY < 28)  
                {
                    Position temp = rocksList[j];
                    temp.posY++;                   
                    rocksList[j] = temp;
                }               
                else  
                {
                    rocksList.Remove(rocksList[j]);
                    playerScore++;
                }                  
            }

            // Dwarf movements
            if (Console.KeyAvailable)
            {
                ConsoleKeyInfo keyInfo = Console.ReadKey();
                if (keyInfo.Key == ConsoleKey.LeftArrow)
                {
                    if (dwarfPosition > 0)
                    {
                        dwarfPosition--;
                    }                     
                }
                if (keyInfo.Key == ConsoleKey.RightArrow)
                {
                    /* The dwarf has 3 chars so the end of the console width will be reached when 
                     * dwarfPosition is equal to the witdth of the console - 2 /gives a total of 3 chars/
                     * the last one of the three ')' will be at the final possible right position.
                    */
                    if (dwarfPosition < Console.WindowWidth - 3)
                    {
                        dwarfPosition++;
                    }                       
                }
            }

            if (playerScore > 250)
            {
                maxNumberOfRocks = 4;
            }
            else if (playerScore > 500)
            {
                maxNumberOfRocks = 6;
            }
            else if (playerScore > 750)
            {
                maxNumberOfRocks = 7;
            }
            else if (playerScore > 1000)
            {
                maxNumberOfRocks = 9;
            }
            else if (playerScore > 1250)
            {
                maxNumberOfRocks = 10;
            }
            else if (playerScore > 1500)
            {
                maxNumberOfRocks = 12;
            }
            else if (playerScore > 1750)
            {
                maxNumberOfRocks = 15;
            }
              
            System.Threading.Thread.Sleep(150);
        }
    }
}



