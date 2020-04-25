/*
Url:-https://leetcode.com/problems/contiguous-array/

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Solution Approach:-Hash Based.

*/

public class Solution {
    public int FindMaxLength(int[] arr) {
         int maxLength=0;
        int sum=0;
        int subArraySize=0;
        Dictionary<int,int> map=new Dictionary<int,int>();  
        // Your code here
        for(int i=0;i<arr.Length;i++){
            if(arr[i]==0){
                arr[i]=-1;
            }
            sum=arr[i]+sum;
            if(sum==0&&maxLength<i+1){
                maxLength=i+1;
            }
            
            if(map.ContainsKey(sum)){
                subArraySize=i-map[sum];
                if(subArraySize>maxLength){
                   maxLength=subArraySize;
                }
                
            }
            
            if(!map.ContainsKey(sum)){
                map.Add(sum,i);  
            }
        }
        
        return maxLength;
    }
}