/*
Url:-https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/

 Given a string S consisting only of opening and closing curly brackets '{' and '}' find out the minimum number of reversals required to make a balanced expression.

Solution Approach:Stack
*/
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

 public class GFG
    {
        public static void Main()
        {
            int testCases = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < testCases; i++)
            {
                string braces = Console.ReadLine();
                CountTheReversal(braces);
            }
        }

        public static void CountTheReversal(string braces)
        {
            var stack = new Stack<char>();
            CompareBraces(braces, stack);
            if (stack.Count == 0)
            {
                Console.WriteLine("0");
            }
            else
            {
                if(stack.Count%2!=0){
                    Console.WriteLine(-1);
                    return;
                }
                int leftBrace =0;
                int rightBrace=0;
                while(stack.Count!=0){
                    if(stack.Pop()=='}') rightBrace++;
                    else leftBrace++;
                }
                //Braces pattern obtained after executing CompareBraces function is of the form }}{{{{{{
                //Basically it is of the form right braces is on left side and left braces on right side
                // if the count of left+right braces is even then we find count otherwise we return-1
                // if left and right braces both of them are even then count will (left+right)/2 }}{{  
                // if left and right is odd  then we will have case }}}{{{  in the middle }{ it require
                // two reverse 

                Console.WriteLine((leftBrace+rightBrace)/2 + leftBrace%2);
            }
        }

        private static void CompareBraces(string braces, Stack<char> stack)
        {
            foreach (var c in braces)
            {
                if (stack.Count > 0)
                {
                    if (stack.Peek() == '{' && c == '}')
                    {
                        stack.Pop();
                    }
                    else
                    {
                        stack.Push(c);
                    }
                }
                else
                {
                    stack.Push(c);
                }
            }
        }
    }