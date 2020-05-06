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


class BinaryTree
{
    public static int min,max,horizontalDistance;
    public static HashMap<Integer, ArrayList<Integer>> map;
    public static Queue<Node> queueNodes ;
    public static Queue<Integer> queueHorizontalDistance = new LinkedList<Integer>();
    static void verticalOrder(Node root)
    {
        queueNodes=new LinkedList<Node>();
        queueHorizontalDistance=new LinkedList<Integer>();
        min=0;max=0;horizontalDistance=0;
        map= new HashMap<Integer, ArrayList<Integer>>();
        queueNodes.add(root);
        queueHorizontalDistance.add(horizontalDistance);
        while(queueNodes.size()!=0){
            
            int currentHeight=queueHorizontalDistance.remove();
            Node currentNode=queueNodes.remove();
            if(currentHeight>max){
                max=currentHeight;
            }
            if(currentHeight<min){
                min=currentHeight;
            }
            if(map.containsKey(currentHeight)){
                map.get(currentHeight).add(currentNode.data);
            }else{
                map.put(currentHeight, new ArrayList<Integer>(){{add(currentNode.data);}}); 
            }
            if(currentNode.left!=null){
                queueNodes.add(currentNode.left);
                queueHorizontalDistance.add(currentHeight-1);
            }
            if(currentNode.right!=null){
                 queueNodes.add(currentNode.right);
                 queueHorizontalDistance.add(currentHeight+1);
            }
        }
        // add your code here
        for(int i=min;i<=max;i++){
        List<Integer> list =map.get(i);
        for(int item:list){  
         System.out.print(item+" ");  
        }  
       }
    }
}