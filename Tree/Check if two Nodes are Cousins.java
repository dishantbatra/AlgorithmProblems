/*
Url:-https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

You are given a binary tree for which you have to print its vertical order traversal. your task is to complete the function verticalOrder which takes one argument the root of the binary tree and prints the node of the binary tree in vertical order as shown below.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal.

Solution Approach:- BFS,HASH MAP
*/

class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class Solution {
    public static Node parentNode;
    public boolean isCousins(Node root, int x, int y) {
     parentNode = null;
     int heightX = getHeightAndSetParent(root, 0, x, null);
     Node nodeX = parentNode;
     parentNode = null;
     int heightY = getHeightAndSetParent(root, 0, y, null);
   
     if (heightX == heightY && heightX != -1 && parentNode != nodeX) {
      return true;
     }
   
     return false;
    }
   
    public int getHeightAndSetParent(Node root, int height, int value, Node parent) {
     if (root == null) {
      return -1;
     }
     if (root.data == value) {
      parentNode = parent;
      return height;
     }
   
     int h = getHeightAndSetParent(root.left, height + 1, value, root);
     if (h != -1) return h;
     h = getHeightAndSetParent(root.right, height + 1, value, root);
     if (h != -1) return h;
   
     return -1;
    }
   
   }