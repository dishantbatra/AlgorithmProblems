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
            var sb = new StringBuilder();
            var stack = new Stack<char>();
            CompareBraces(braces, stack);
            if (stack.Count == 0)
            {
                Console.WriteLine("0");
            }
            else
            {
                PrintReversalCount(stack, sb);
            }
        }

        private static void PrintReversalCount(Stack<char> stack, StringBuilder sb)
        {
            var count = 0;
            var reversalStack = new Stack<char>();
            while (stack.Count != 0)
            {
                sb.Append(stack.Pop());
            }

            var s = new string(sb.ToString().Reverse().ToArray());
            foreach (var c in s)
            {
                if (reversalStack.Count == 0 && c == '}')
                {
                    count++;
                    reversalStack.Push('{');
                }
                else
                {
                    if (reversalStack.Count > 0 && reversalStack.Peek() == '{' && c == '}')
                    {
                        reversalStack.Pop();
                    }
                    else
                    {
                        reversalStack.Push(c);
                    }
                }
            }

            if (reversalStack.Count % 2 == 0)
            {
                Console.WriteLine(count + reversalStack.Count / 2);
            }
            else
            {
                Console.WriteLine(-1);
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