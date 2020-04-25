/*
Url:-https://www.geeksforgeeks.org/nearly-sorted-algorithm/

Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

Solution Approach:-Simpling looping the array
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
            Sort(arr, n[1]);
        }
        return;
    }

    public static void Sort(int[] arr, int k)
    {
        for (int i = 0; i < arr.Length; i++)
        {
            var minPosition = i;
            for (int j = i + 1; j <= (i + k) && (j < arr.Length); j++)
            {
                if (arr[minPosition] > arr[j])
                {
                    minPosition = j;
                }
            }
            if (minPosition != i)
            {
                var temp = arr[minPosition];
                arr[minPosition] = arr[i];
                arr[i] = temp;
            }
        }
        foreach (var a in arr)
        {
            Console.Write($"{a} ");
        }
        Console.WriteLine();
    }
}