/*
Url:-https://leetcode.com/problems/binary-tree-inorder-traversal/

K distance from root.

Solution Approach:- Pre Order Traversl if height we reached that height we don't need to  go down .
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
              return ;
          }
          height++;
          printKdistance(root.left,k);
          printKdistance(root.right,k);
          height--;
     }
}