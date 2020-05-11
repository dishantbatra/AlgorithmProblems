/*
Url:-https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

Level order traversal in spiral form

Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.
Solution Approach:- BFS,Stack
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


class Spiral
{
      void printSpiral(Node node) 
      {
           // Your code here
           Stack<Node> stack1 = new Stack<Node>();
           Stack<Node> stack2 =  new Stack<Node>();
           if(node!=null){
               stack1.push(node);
           }
           
           Node item;
           while(stack1.size()>0||stack2.size()>0){
             while(stack1.size()>0){
              item=stack1.pop();
              System.out.print(item.data+" ");
              if(item.right!=null){
                  stack2.push(item.right);
              }
              if(item.left!=null){
                  stack2.push(item.left);
              }
            }  
            while(stack2.size()>0){
              item=stack2.pop();
              System.out.print(item.data+" ");
              if(item.left!=null){
                  stack1.push(item.left);
              }
              if(item.right!=null){
                  stack1.push(item.right);
              }
              
            }  
           }
      }
}