/*
Url:-https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
Given inorder and postorder traversals of a Binary Tree in the arrays in[] and post[] respectively. The task is to construct the binary tree from these traversals.
For example, if given inorder and postorder traversals are {4, 8, 2, 5, 1, 6, 3, 7} and {8, 4, 5, 2, 6, 7, 3, 1}  respectively, then your function should construct below tree.

          1
       /      \
     2        3
   /    \     /   \
  4     5   6    7
    \
      8
Solution Approach:- Post Order helps in determining the root and hashmap
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

class GfG {
    // Complete the function
    public static Map<Integer, Integer> map ;
    public static int currentIndex;
    Node buildTree(int in[], int post[], int n) {
         map = new Hashtable<Integer, Integer>(); 
         currentIndex=in.length;
         for(int i =0;i<in.length;i++){
             map.put(in[i],i);
         }
         return ConstructTree(in,post,0,post.length-1);
    }
    
    Node ConstructTree(int[] in,int[] post,int start,int end){
        if(start>end) return null ;
        currentIndex--;
        Node node = new Node(post[currentIndex]);
        int indexValueInInOrder = map.get(node.data);
        node.right=ConstructTree(in,post,indexValueInInOrder+1,end); 
        node.left=ConstructTree(in,post,start,indexValueInInOrder-1);
        return node;
    }
}
