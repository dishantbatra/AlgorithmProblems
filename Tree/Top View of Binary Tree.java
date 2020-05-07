/*
Url:-https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node.
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

class View
{
    public static Map<Integer, Integer> map ;
    public static Queue<Node> nodeQueue;
    public static Queue<Integer> horizontalDistanceQueue;
    public static int horizontalDistance;
    public static int min,max;
    
    // function should print the topView of the binary tree
    public static void topView(Node root)
    {
       min=0;max=0;
       nodeQueue =  new LinkedList<Node>(); 
       horizontalDistanceQueue = new LinkedList<Integer>();
       map = new Hashtable<Integer, Integer>(); 
       nodeQueue.add(root);
       horizontalDistanceQueue.add(0);
       Node currentNode;
       int currentHorizontalDistance;
       while(nodeQueue.size()!=0){
          currentNode= nodeQueue.remove();
          currentHorizontalDistance=horizontalDistanceQueue.remove();
         if(currentHorizontalDistance<min){
             min=currentHorizontalDistance;
         }
         
         if(currentHorizontalDistance>max){
             max=currentHorizontalDistance;
         }
        if(!map.containsKey(currentHorizontalDistance)){
          map.put(currentHorizontalDistance, currentNode.data);  
          }
        if(currentNode.left!=null){
              nodeQueue.add(currentNode.left);
              horizontalDistanceQueue.add(currentHorizontalDistance-1);
          }
          if(currentNode.right!=null){
              nodeQueue.add(currentNode.right);
              horizontalDistanceQueue.add(currentHorizontalDistance+1);
          }  
          
       }
       for(int i=min;i<=max;i++){
           System.out.print(map.get(i) + " ");
       }
    }
    
}