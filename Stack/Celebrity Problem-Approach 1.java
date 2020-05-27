/*
Url:-https://www.geeksforgeeks.org/the-celebrity-problem/

 You are in a party of N people, where only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. Your task is to find the stranger (celebrity) in party.
You will be given a square matrix M[][] where if an element of row i and column j  is set to 1 it means ith person knows jth person. You need to complete the function getId() which finds the id of the celebrity if present else return -1. The function getId() takes two arguments, the square matrix M and its size N.
Here, M[i][i] will be equal to zero.
Note: Expected time complexity is O(N) with constant extra space.

Solution Approach:Traverse
*/

 class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        int celebrityId =-1;
        for(int i =0;i<n;i++){
            Boolean  isEveryOneKnowHim =true;
            Boolean  isHeKnowAnyone =false;
            for(int j=0;j<n;j++){
                // is HeKnowAnyone
                if(M[i][j]==1){
                    isHeKnowAnyone=true;
                    break;
                }
            }
            if(!isHeKnowAnyone){
                //isEveryOneKnowHim
                for(int j=0;j<n;j++){
                // is HeKnowAnyone
                if(i!=j && M[j][i]==0){
                    isEveryOneKnowHim=false;
                    break;
                }
            }
            }
            if(isEveryOneKnowHim && !isHeKnowAnyone ){
                return i;
            }    
        }
        return celebrityId;    
    }
}
