/*
Url:-https://www.geeksforgeeks.org/bottom-view-binary-tree/

Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.

Solution Approach:- BFS AND HASHMAP.
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
    public static Queue<Node> nodeQueue;
    public static Queue<Integer> horizontalDistanceQueue;
    public static int horizontalDistance;
    public static int min,max;
 
    // Method that prints the bottom view.
    public void bottomView(Node root)
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
         map.put(currentHorizontalDistance, currentNode.data);
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