/*
Url:-https://practice.geeksforgeeks.org/problems/maximum-difference-1587115620/1

Given array A[] of integers, the task is to complete the function findMaxDiff 
which finds the maximum absolute difference between nearest left and right smaller 
element of every element in array.If the element is the leftmost element, nearest 
smaller element on left side is considered as 0. Similarly if the element is the 
rightmost elements, smaller element on right side is considered as 0.
Examples:

Input : arr[] = {2, 1, 8}
Output : 1
Left smaller  LS[] {0, 0, 1}
Right smaller RS[] {1, 0, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 1 

Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
Output : 4
Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 7 - 3 = 4 

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output : 1
Solution Approach: Stack.
*/
// { Driver Code Starts
     
    
    class GfG
{
    int findMaxDiff(int arr[], int n)
    {
    	int[] lArr = new int[n];
        int[] rArr = new int[n];
        int currentMax=-1;
        Stack<Integer> lStack = new Stack<Integer>();
        Stack<Integer> rStack = new Stack<Integer>();
        rArr[n-1]=0;
        lArr[0]=0;
        for(int i =1;i<arr.length;i++){
                if(arr[i-1]<arr[i]){
                    lStack.push(arr[i-1]);
                    lArr[i]=arr[i-1];
                }else{
                    while(lStack.size()!=0){
                        if(lStack.peek()<arr[i]){
                            lArr[i]=lStack.peek();
                            break;
                        }else{
                            lStack.pop();
                        }
                    }
                    if(lStack.size()==0){
                        lArr[i]=0;
                    }
                }
        }
        for(int i =n-2;i>=0;i--){
                if(arr[i]>arr[i+1]){
                    rStack.push(arr[i+1]);
                    rArr[i]=arr[i+1];
                }else{
                    while(rStack.size()!=0){
                        if(rStack.peek()<arr[i]){
                            rArr[i]=rStack.peek();
                            break;
                        }else{
                            rStack.pop();
                        }
                    }
                    if(rStack.size()==0){
                        rArr[i]=0;
                    }
                }
        } 
        for(int i=0;i<n;i++){
            if(Math.abs(lArr[i]-rArr[i])>currentMax){
                currentMax= Math.abs(lArr[i]-rArr[i]);
            }
        }
        return currentMax;
    }
}