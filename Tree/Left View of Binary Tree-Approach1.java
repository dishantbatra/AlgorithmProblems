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

Solution Approach:- INORDER AND HASHMAP.
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
    public static Map<Integer, Integer> map ;
    void leftView(Node root)
    {
      map = new Hashtable<Integer, Integer>(); 
      int height=0;
      inOrder(root,0);
      while(map.containsKey(height)){
          System.out.print(map.get(height)+" ");
          height++;
      } 
    }
    
    public void inOrder(Node root,int height){
        if(root==null){
            return;
        }
        inOrder(root.left,height+1);
         if(!map.containsKey(height)){
            map.put(height,root.data);  
        }
        inOrder(root.right,height+1);
       
    }
}