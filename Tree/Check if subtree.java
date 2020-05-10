/*
Url:-https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

Example:

S:          10
              /   \
            4     6
                 /
             30

T:                  26
                      /   \
                    10   3
                   /   \     \

               4       6     3
                       /
                    30

In above example S is subtree of T.

Please note that subtree has to be having same leaves non leaves.

   10
  /
20

For example, above tree is not subtree of

         10
       /     \
    20     50
   /   \
30   40

But a subtree of

         30
       /     \
    10     50
   /  
20  

Solution Approach:- Search AND Compare.
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