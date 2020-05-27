/*
Url:-https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer Q denoting the number of queries.
A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out  or min element from the stack.
Solution Approach: Store min element at top and element below it
*/

class GfG
{
    int minEle;
    Stack<Integer> s = new Stack<Integer>();

    /*returns min element from stack*/
    int getMin()
    {
        if(s.size()==0)return -1;
	// Your code here
	return s.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
	if(s.size()==0){
	    return -1;
	}else{
	s.pop();
	return s.pop();
	}
    }

    /*push element x into the stack*/
    void push(int x)
    {
    	if(s.size()==0){
            s.push(x);	
            s.push(x);
    	}else{
    	    int peek=s.peek();
    	    if(peek>x){
    	       s.push(x);	
               s.push(x); 
    	    }else{
    	        s.push(x);	
                s.push(peek);
    	    }
    	}
    }	
}
