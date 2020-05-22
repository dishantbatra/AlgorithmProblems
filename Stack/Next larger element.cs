/*
Url:-https://www.geeksforgeeks.org/next-greater-element/

 Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1 

Solution Approach:Stack
*/
using System;
using System.Collections.Generic; 
using System.Linq;
public class GFG {
	static public void Main () {
		var t = Convert.ToInt64(Console.ReadLine());
        for (int i = 0; i < t; i++)
        {
            var n = Convert.ToInt64(Console.ReadLine());
            var arr = Array.ConvertAll(Console.ReadLine().Trim().Split(), x => Convert.ToInt64(x));
            NextLargerElement(arr);
            Console.WriteLine("");
        }
	}
	
	static public void NextLargerElement(Int64 []arr){
	    var nextLargestElement =Enumerable.Repeat<Int64>(-1,arr.Length).ToArray();
	    var indexStack = new Stack<Int64>();

	    for(Int64 i =0;i<arr.Length;i++){
	        if(indexStack.Count==0){
	           indexStack.Push(i);
	        }else{
                //Loop till stack is not empty
	            while(indexStack.Count>0){
	                Int64 topIndex=indexStack.Peek();
                    //If element at the peek of the stack is less than the element we are travesing ,then traversing element is put at particular index
	                if(arr[i]>arr[topIndex]){
	                    nextLargestElement[topIndex]=arr[i];
	                    indexStack.Pop();
	                }else{
	                      //if the the element we are traversing is smaller than the stack peek element
	                      break;
	                }
	            }
                //Push the index of the traverse element in order to find its right side closes element.
	            indexStack.Push(i);
	        }
	    }
	    foreach(var a  in nextLargestElement){
	        Console.Write(a+ " ");
	    }
	}
}