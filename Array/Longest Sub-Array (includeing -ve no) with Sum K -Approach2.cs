/*
Url:-https://www.geeksforgeeks.org/longest-sub-array-sum-k/

Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.

Solution Approach:-Hash Based.

*/

using System;
using System.Collections.Generic;
public class GFG
{
    public static void Main()
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
        int maxLength = 0;
        int sum = 0;
        var map = new Dictionary<int, int>();
        for (int i = 0; i < arr.Length; i++)
        {
            sum += arr[i];
			if (!map.ContainsKey(sum))
            {
                map.Add(sum, i);
            }
			if(sum==k && maxLength<i+1){
				maxLength=i+1;
				continue;
			}
            
            var diff = sum - k;
            if (map.ContainsKey(diff))
            {
                var index = map[diff];
                if (maxLength < i - index)
                {
                    maxLength = i - index;
                }
            }
        }
        Console.WriteLine(maxLength);
    }
}