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
Solution Approach: Algebra approach.
*/
// { Driver Code Starts
     
    
    class GfG
    {
        int minEle;
        Stack<Integer> s = new Stack<Integer>();
    
        /*returns min element from stack*/
        int getMin()
        {
            if(s.size()==0)return -1;
            
            return minEle;
        }
        
        /*returns poped element from stack*/
        int pop()
        {
            if(s.size()==0)return -1;
           
            int pop = s.pop();
            if(s.size()==0) return pop;
            //While pushing we are checking that the element we are pushing is
            //less than current min element.If the element is less than current min
            //we are pushing 2*x-currentMin and updating currentMin=x(as 2*x-currentMin will always less than currentMin if currentMin>x)
            //As,we know whenever poping we find minEle>elementPop it means we need to update current min
            //So,currentMin=2*currentMin - popElement and  element to be returned is the currentMin
            //value before updating in the previous operation.
            if(minEle>pop){
                int min=minEle;
                minEle =2*minEle -pop;
                return min;
            }
            return pop;
        }
    
        /*push element x into the stack*/
        void push(int x)
        {
            if(s.size()==0){
                minEle=x;
                s.push(x);
            }else{
                //If current minimum is greater than no being pushed then we have
                //to push a no in such a way that whenever element is poped we can identify 
                //that minEle value need to be updated
                //if x is less than current element then we can be sure that
                //2*x - minEle < x 
                //Example : 2*1 - 3 <x
                //So whenever the element at peek of the stack is less than current min we can be sure 
                //we have to update the current minEle
                if(minEle>x){
                  s.push(2*x-minEle);
                  minEle=x;
                }else{
                    s.push(x);
                }
            }
            
        }	
    }
    
    