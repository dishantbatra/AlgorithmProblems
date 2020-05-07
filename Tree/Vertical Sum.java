/*
Url:-https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/

Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line. Print all sums through different vertical lines.
Examples:

      1
    /   \
  2      3
 / \    / \
4   5  6   7

Solution Approach:- HASH MAP,Pre Order Traversal
*/


class Node{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null
    }
    }

class Tree{
    public static int min,max,currentLevel;
    public static HashMap<Integer, ArrayList<Integer>> map;
    public void verticalSum(Node root) {
    
       map= new HashMap<Integer, ArrayList<Integer>>();
       min=0;max=0;currentLevel=0;
       traverseVertically(root);
       for(int i=min;i<=max;i++){
        List<Integer> list =map.get(i);
        int sum=0;
        for(int item:list){  
            sum=sum+item;  
        }  
        System.out.print(sum+" ");  
       }
    }
    
    static void traverseVertically(Node root){
        if(root==null){
            return ;
        }
        if(currentLevel<min){
            min=currentLevel;
        }else if(currentLevel>max){
            max=currentLevel;
        }
        if(map.containsKey(currentLevel)){
            map.get(currentLevel).add(root.data);
        }else{
             map.put(currentLevel, new ArrayList<Integer>(){{add(root.data);}}); 
        }
        
        currentLevel--;
        traverseVertically(root.left);
        currentLevel++;
        currentLevel++;
        traverseVertically(root.right);
        currentLevel--;
    }
}
