/*
Url:-https://www.geeksforgeeks.org/print-left-view-binary-tree/
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    / \
  4     5   6    7
   \
     8   
For the above tree, the bottom view is 1 2 4 5 7 .

Solution Approach:- PreOrder AND MaxHeight.
*/

public class Node
{
        public Node left;
        public Node right;
        public int val;

        public Node(int val = 0, Node left = null, Node right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}  
class Tree
{
    public static int maxHeight;
    void leftView(Node root)
    { 
      maxHeight=-1;
      postOrder(root,0);
    }
    
    public void postOrder(Node root,int height){
        if(root==null){
            return;
        }
        if(maxHeight<height){
           System.out.print(root.data+" ");
           maxHeight=height;
        }
        postOrder(root.left,height+1);
        
        postOrder(root.right,height+1);
       
    }
}