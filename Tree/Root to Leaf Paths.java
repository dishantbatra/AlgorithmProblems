/*
Url:-https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/

Given a Binary Tree of size N, your task is to complete the function printPaths() that prints all the possible paths from root node to the all the leaf node's of the binary tree.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
All possible paths:
1->2->4
1->2->5
1->3->6
1->3->7
Solution Approach:- BFS,HASH MAP
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

public void printPaths(Node root){
    prinLeafNodePath(root,root.data+" ");
}
    
public void  prinLeafNodePath(Node root,String str){
        if(root==null)return;
        if(root.left==null & root.right==null){
            System.out.print(str+"#");
        }
        if(root.left!=null){
            prinLeafNodePath(root.left,str+root.left.data+" ");
        }
        
        if(root.right!=null){
             prinLeafNodePath(root.right,str+root.right.data+" ");
        }
}