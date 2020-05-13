/*
Url:-https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/

Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. You are required to complete the function maxDiff. 
Solution Approach:- Post Order Traversal.
*/


class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Tree
{
    public static int max=0;
    int maxDiff(Node root)
    {
        max=Integer.MIN_VALUE ;
        GetMin(root);
        return max;
    }
    
    public  static int GetMin(Node root){
        int currentTreeMin;
        int leftMin =Integer.MAX_VALUE ;
        int rightMin =Integer.MAX_VALUE ;
        
        if(root.left==null && root.right==null){
          return root.data;  
        }
            
        if(root.left!=null){
            leftMin = GetMin(root.left);
        }
        
        if(root.right!=null){
            rightMin = GetMin(root.right);
        }
        
        if(leftMin>rightMin){
            currentTreeMin=rightMin;
        }else{
            currentTreeMin=leftMin;
        }
        if(root.data-currentTreeMin>max){
            max=root.data-currentTreeMin;
        }
        if(currentTreeMin>root.data){
            return root.data;
        }
        return currentTreeMin;
    }
    
}

