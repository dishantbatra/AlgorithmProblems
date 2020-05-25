/*
Url:-https://www.geeksforgeeks.org/the-stock-span-problem/

 The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
Solution Approach:- Stack 
*/
using System;
using System.Collections.Generic;
using System.Linq;
public class GFG {
	static public void Main () {
		int t = Convert.ToInt32(Console.ReadLine().Trim());
		for(int i=0;i<t;i++){
		    var n = Convert.ToInt32(Console.ReadLine().Trim());
		    var arr=Array.ConvertAll(Console.ReadLine().Trim().Split(' '), aTemp => Convert.ToInt32(aTemp));
	        GetStockSpan(arr);
		}
	}
	
	static public void GetStockSpan(int []arr){
        //For storing the check point .
        //Example:- for 100, 80, 60, 70, 60, 75, 85
        // we don't need to store index 60 in stack after element 70 is processed .
        // if any no which is greater than 70 will definately going to be greater than 60
        //Which will help in maintaing stack size small.
	    var stack = new Stack<int>(); 
	    var spansArray = Enumerable.Repeat(1, arr.Length).ToArray();
	    stack.Push(0); // First Element will never be compared so we will start comparing with second element
	    for(int i=1;i<arr.Length;i++){
	       while(stack.Count>0&&arr[stack.Peek()]<=arr[i]){
	           stack.Pop();
	       }
	       if(stack.Count>0){ //If stack is non empty
                //With the help of the value at the peek of stack we 
                //can get upto how many element our current element is greater
	           spansArray[i]=spansArray[i]+i-stack.Peek()-1;
	       }else{ //if stack is empty
	           spansArray[i]=spansArray[i]+i;
	       }
           //We are storing indexes of check point element
	       stack.Push(i);
	    }
	    for(int i =0;i<spansArray.Length;i++){
	        Console.Write(spansArray[i]+" ");
	    }
	    Console.WriteLine();
	}
}
