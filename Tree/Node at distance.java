/*
Url:-https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/

Given a Binary Tree of N nodes and a positive integer k. The task is to count all distinct nodes that are distance k from a leaf node. A node is at k distance from a leaf if it is present k levels above the leaf and also, is a direct ancestor of this leaf node. For example, if k is more than the height of Binary Tree, then nothing should be counted.

Input:
The first line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
Solution Approach:- Pre Order and Utility Function To Checkc if leaf node exist at particular distance
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

class Solution{

    static int count;
    int printKDistantfromLeaf(Node root, int k)
    {
        count=0;
        // Write your code here
        PreOrder(root,k);
        return count;
    }
    
    public static void PreOrder(Node root,int k){
        if(root==null){
            return ;
        }
        if(isLeafNodeExistAtKDistance(root,k,0)) count++;
        PreOrder(root.left,k);
        PreOrder(root.right,k);
    }
    
    public static boolean isLeafNodeExistAtKDistance(Node root,int k,int height){
        
        if(height>k){
            return false;
        }
        if(root.left==null && root.right==null){
            if(k==height){
                return true;
            }
            return false;
        }
        boolean leftSubtree=false;
        if(root.left!=null&&k>height){
           leftSubtree=isLeafNodeExistAtKDistance(root.left,k,height+1); 
        }
        if(leftSubtree) return leftSubtree;
        boolean rightSubtree=false;
        
        if(root.right!=null&&k>height){
           rightSubtree=isLeafNodeExistAtKDistance(root.right,k,height+1); 
        }
        
        return leftSubtree || rightSubtree;
        
    }
}
