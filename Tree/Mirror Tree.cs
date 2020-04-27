/*
Url:-https://practice.geeksforgeeks.org/problems/mirror-tree/1

Given a Binary Tree, convert it into its mirror.

Solution Approach:-Swapping.

*/

class Tree
{
    void mirror(Node node)
    {
	// Your code here
	   if(node!=null){
	       Node temp=node.left;
	       node.left=node.right;
	       node.right=temp;
	       mirror(node.left);
	       mirror(node.right);
	   }
    }
}