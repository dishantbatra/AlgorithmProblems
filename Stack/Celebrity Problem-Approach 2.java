/*
Url:-https://www.geeksforgeeks.org/the-celebrity-problem/

 You are in a party of N people, where only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. Your task is to find the stranger (celebrity) in party.
You will be given a square matrix M[][] where if an element of row i and column j  is set to 1 it means ith person knows jth person. You need to complete the function getId() which finds the id of the celebrity if present else return -1. The function getId() takes two arguments, the square matrix M and its size N.
Here, M[i][i] will be equal to zero.
Note: Expected time complexity is O(N) with constant extra space.

Solution Approach:Stack
*/

class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {   
        int candidate =getPossibleCelbrityId(M,n);
        if(candidate!=-1){
            //isHeKnowsAnyone
            for(int i =0;i<n;i++){
                if(i!=candidate && M[candidate][i]==1){
                    return -1;
                }
            }
            //isEveryoneKnowsHim
            for(int i =0;i<n;i++){
                if(i!=candidate && M[i][candidate]!=1){
                    return -1;
                }
            }
            return candidate;
        }
        return -1;
    }


    //There can only one celebrity in the given problem as everyone knows him and he knows no one
    //using this logic we can compare candidates with each using stack,among 2 candidate only one 
    //can be possible celebrity candidate ,both of them can't ,using this logic we minimize the 
    //output set for possible candidate
     int getPossibleCelbrityId(int M[][], int n){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<n;){
            if(stack.size()==0){
                if(i==n-1){
                    return i;
                }else{
                    stack.push(i++);
                    stack.push(i++);
                }
            }else{
              stack.push(i++);  
            }
            int candidate1 = stack.pop();
            int candidate2 =stack.pop();
            int candidate = getPossibleCandidate(M, candidate1,candidate2);
            if(candidate!=-1){
                stack.push(candidate);
            }
        }
        if(stack.size()==0){
            return -1;
        }
        return stack.pop();
    }
    //If candidate 1 knows candidate 2 then candidate 1 will not be celebrity
    //If candidate 2 knows candidate 1 then candidate 1 will not be celebrity
    //If candidate 2 doesn't know candidate 1 and candidate 1 knows candidate 2 then candidate 2 can pe possible celebrity candidate
    //If candidate 1 doesn't know candidate 2 and candidate 2 knows candidate 1 then candidate 1 can pe possible celebrity candidate
    //If they don't know each other then  there non of them are celebrity candidate
    int  getPossibleCandidate(int M[][],int candidate1,int candidate2){
        boolean  isCandidate1KnowsCandiate2=false;
        boolean  isCandidate2KnowsCandiate1=false;
        if(M[candidate1][candidate2]==1){
            isCandidate1KnowsCandiate2=true;
        }
        if(M[candidate2][candidate1]==1){
            isCandidate2KnowsCandiate1=true;
        }
        
        if(isCandidate1KnowsCandiate2 &&!isCandidate2KnowsCandiate1){
            return candidate2;
        }
        if(isCandidate2KnowsCandiate1 &&!isCandidate1KnowsCandiate2){
            return candidate1;
        }return -1;
    }
}