/*
Url:-https://www.geeksforgeeks.org/evaluation-of-expression-tree/

Given a simple expression tree, which is also a full binary tree consisting of basic binary operators i.e., + , – ,* and / and some integers, Your task is to evaluate the expression tree.

Input Format:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer N denoting the no of nodes. Then in the next line are N space separated values of the nodes of the Binary tree filled in continous way from the left to the right.

Solution Approach:- Post Order
*/

class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
    class Tree
{
    static int height=0;
     // Recursive function to print right view of a binary tree.
     void printKdistance(Node root, int k)
     {
         if(root==null){
             return;
         }
          // Your code here
          if(height==k){
              System.out.print(root.data+" ");
              height--;
              return ;
          }
          height++;
          printKdistance(root.left,k);
          printKdistance(root.right,k);
          height--;
     }
}