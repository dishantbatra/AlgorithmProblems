/*
Url:-https://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/
Print extreme nodes of each level of Binary Tree in alternate order
Given a binary tree, print nodes of extreme corners of each level but in alternate order.

Solution Approach:- BFS AND STACK.
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
class Tree{
    public  void printExtremeNode(Node node)
      {
          Node item;
          Stack<Node> stack1 = new Stack<Node>();
          Stack<Node> stack2 = new Stack<Node>();
          stack1.push(node);
          while(stack1.size()>0||stack2.size()>0){
              item=null;
              while(stack1.size()>0){
                  item =stack1.pop();
                  if(item.left!=null){
                      stack2.push(item.left);
                  }
                  if(item.right!=null){
                      stack2.push(item.right);
                  }
              }
              if(item!=null){
                  System.out.print(item.data+" ");
                  item=null;
              }
              
              while(stack2.size()>0){
                  item =stack2.pop();
                  if(item.right!=null){
                      stack1.push(item.right);
                  }
                  if(item.left!=null){
                      stack1.push(item.left);
                  }
              }
              if(item!=null){
                  System.out.print(item.data+" ");
              }
          }
      }
}