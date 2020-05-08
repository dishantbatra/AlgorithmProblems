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
    public class NodeInfo{
        public NodeInfo(int data,int verticalDistance) {
            this.verticalDistance=verticalDistance;
            this.data=data;
        }
    int verticalDistance;
    int data;
    }
    public static Map<Integer, NodeInfo> map ;
    public static int min,max;
    // Method that prints the bottom view.
    public void bottomView(Node root)
    {
       map= new Hashtable<Integer, NodeInfo>();  
       min=0;max=0;
       inOrder(root,0,0);
       for(int i=min;i<=max;i++){
           System.out.print(map.get(i).data + " ");
       }
    }
    
    public void inOrder(Node root,int horizontalDistance,int height){
        if(root==null){
            return ;
        }
        inOrder(root.left,horizontalDistance-1,height+1);
        if(horizontalDistance>max){
            max=horizontalDistance;
        }
        
        if(horizontalDistance<min){
            min=horizontalDistance;
        }
        if(!map.containsKey(horizontalDistance)){
            map.put(horizontalDistance,new NodeInfo(root.data,height));  
        }else{
            NodeInfo node = map.get(horizontalDistance);
            if(height>=node.verticalDistance){
                map.put(horizontalDistance, new NodeInfo(root.data,height));  
            }
        }
        inOrder(root.right,horizontalDistance+1,height+1);
    }
}