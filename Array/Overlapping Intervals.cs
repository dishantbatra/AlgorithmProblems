/*
Url:-https://www.geeksforgeeks.org/merging-intervals/

Given a collection of Intervals,merge all the overlapping Intervals.
For example:

Given [1,3], [2,6], [8,10], [15,18],

return [1,6], [8,10], [15,18].

Make sure the returned intervals are sorted.

Solution Approach:Sorting and Comparing the input
*/
using System;
using System.Collections.Generic;
using System.Linq;
public class Range{
    public double start{get;set;}
    public double end{get;set;}
}
public class GFG {
	static public void Main () {
		int testCases= Convert.ToInt32(Console.ReadLine());
		
		for(int i =0 ;i<testCases;i++){
		  double totalInput= Convert.ToInt32(Console.ReadLine());
		  List<Range> items = new List<Range>();
		  double[] array = Array.ConvertAll(Console.ReadLine().Trim().Split(' '), aTemp => Convert.ToDouble(aTemp));
		  for(int j =0 ; j<array.Length;){
		      items.Add(new Range(){
		         start=array[j],
		         end=array[j+1]
		      });
		     j+=2;
		  }  
		  items=items.OrderBy(x=>x.start).ToList();
		  PrdoubleGroup(items);
		  Console.WriteLine();
		}
	}
	
	public static void PrdoubleGroup(List<Range> items){
	     var current =items.First();
	     foreach(var a in items){
	       if(a.start<=current.end){
	           if(a.end>current.end){
	               current.end=a.end;
	           }
	       }else{
	            Console.Write(current.start+" ");
	             Console.Write(current.end+" ");
	             current=a;
	       }
	     }
	     Console.Write(current.start+" ");
	     Console.Write(current.end+" ");
	}
}