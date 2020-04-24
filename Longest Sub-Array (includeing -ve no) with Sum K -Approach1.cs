/*
Url:-https://www.geeksforgeeks.org/longest-sub-array-sum-k/

Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.

Solution Approach:-Sliding Window.

*/

using System;
public class GFG
{
    static public void Main()
    {
        var t = Convert.ToInt32(Console.ReadLine());
        for (int i = 0; i < t; i++)
        {
            var n = Array.ConvertAll(Console.ReadLine().Trim().Split(), x => Convert.ToInt32(x));
            var arr = Array.ConvertAll(Console.ReadLine().Trim().Split(), x => Convert.ToInt32(x));
            PrintMaxLength(arr, n[1]);

        }
    }

    public static void PrintMaxLength(int[] arr, int k)
    {

        int[] arrSum = new int[arr.Length];
        arrSum[0] = arr[0];
        for (int i = 1; i < arr.Length; i++)
        {
            arrSum[i] = arr[i] + arrSum[i - 1];
        }

        if (arrSum[arr.Length - 1] == k)
        {
            Console.WriteLine(arr.Length);
            return;
        }

        for (int windowSize = arr.Length - 1; windowSize > 0; windowSize--)
        {
            for (int startIndex = 0; startIndex + windowSize - 1 < arr.Length; startIndex++)
            {
                var endIndex = startIndex + windowSize - 1;
                if (endIndex == startIndex)
                {
                    if (startIndex == 0)
                    {
                        if (arrSum[0] != k) continue;
                        Console.WriteLine("1");
                        return;

                    }
                    else
                    {
                        if (arrSum[endIndex] - arrSum[startIndex - 1] != k) continue;
                        Console.WriteLine("1");
                        return;
                    }
                }
                else
                {
                    if (startIndex == 0)
                    {
                        if (arrSum[endIndex] != k) continue;
                        Console.WriteLine(endIndex + 1);
                        return;

                    }
                    else
                    {
                        if (arrSum[endIndex] - arrSum[startIndex - 1] != k) continue;
                        Console.WriteLine(endIndex - startIndex + 1);
                        return;
                    }
                }
            }
        }
        Console.WriteLine("0");
    }
}