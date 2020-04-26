/*
Url:-https://leetcode.com/problems/subarray-sum-equals-k/

Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator in O(n) time.

Solution Approach:-Associativity property of multiplication.

*/

using System;
public class GFG
{
    public static void Main()
    {
        var t = Convert.ToInt32(Console.ReadLine());
        for (int i = 0; i < t; i++)
        {
            var n = Convert.ToInt32(Console.ReadLine());
            var arr = Array.ConvertAll(Console.ReadLine().Trim().Split(), x => Convert.ToInt32(x));
            Multiply(arr);
        }
        return;

    }

    public static void Multiply(int[] arr)
    {
        int[] productLeftSide = new int[arr.Length];
        int[] productRightSide = new int[arr.Length];
        productLeftSide[0] = 1;
        productRightSide[arr.Length - 1] = 1;
        for (var i = 1; i < arr.Length; i++)
        {
            productLeftSide[i] = productLeftSide[i - 1] * arr[i - 1];
        }
        for (var i = arr.Length - 2; i >= 0; i--)
        {
            productRightSide[i] = productRightSide[i + 1] * arr[i + 1];
        }
        for (var i = 0; i < arr.Length; i++)
        {
            arr[i] = productLeftSide[i] * productRightSide[i];
        }
        foreach (var a in arr)
        {
            Console.Write($"{a} ");
        }
        Console.WriteLine("");
    }
}