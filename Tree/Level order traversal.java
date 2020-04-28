/*
Url:- https://practice.geeksforgeeks.org/problems/level-order-traversal/1

You are given a tree and you need to do the level order traversal on this tree.
Level order traversal of a tree is breadth-first traversal for the tree.

Solution Approach:-Queue Based.

*/

class Level_order_traversal
{
    //You are required to complete this method
    static void levelOrder(Node node) 
    {
        // Your code here
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node item = queue.poll(); ;
            if(item.left!=null){
                queue.add(item.left);
            }
            if(item.right!=null){
                queue.add(item.right);
            }
            System.out.print(item.data+" ");
        }
    }
}
