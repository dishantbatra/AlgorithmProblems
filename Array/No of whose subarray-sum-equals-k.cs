/*
Url:-https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Solution Approach:-Hash Based.

*/

using System.Collections.Generic;

public class Solution
{
    public int SubarraySum(int[] arr, int k)
    {
        int result = 0;
        int sum = 0;
        var map = new Dictionary<int, int>();
        foreach (var item in arr)
        {
            sum += item;
            if (sum == k)
            {
                result++;
            }
            var diff = sum - k;
            if (map.ContainsKey(diff))
            {
                result += map[diff];
            }
            if (!map.ContainsKey(sum))
            {
                map.Add(sum, 1);
            }
            else
            {
                map[sum] += 1;
            }
        }

        return result;
    }
}