/*
Url:-https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

Serialize and Deserialize a Binary Tree

Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to tree and returns it.

Solution Approach:- BFS AND Queue
*/

class Tree {
    
	public void serialize(Node root, ArrayList<Integer> A) {
	    Queue<Node> nodeQueue = new LinkedList<Node>();
	    nodeQueue.add(root);
	    while(nodeQueue.size()>0){
	        Node removeNode = nodeQueue.remove();
	        if(removeNode!=null){
	            A.add(removeNode.data);
	            nodeQueue.add(removeNode.left);
	            nodeQueue.add(removeNode.right);
	        }else{
	            A.add(null);
	        }
	    }
	}
	
    public Node deSerialize(ArrayList<Integer> A){
        Queue<Node> nodeQueue = new LinkedList<Node>();
	    Node rootNode= new Node(A.get(0));
	    nodeQueue.add(rootNode);
	     for (int i = 1; i < A.size();){
	         Node removeNode =  nodeQueue.remove();
	         Node left =null;
	         Node right =null;
	         Integer item = A.get(i);
	         if(item!=null){
	             left = new Node(item);
	             nodeQueue.add(left);
	         }
	         i++;
	         if(i<A.size()){
	            item = A.get(i);
	            if(item!=null){
	             right = new Node(item);
	             nodeQueue.add(right);
	         }
	            
	         }
	         i++;
	         removeNode.left = left;
	         removeNode.right= right;
	     }
	     return rootNode;
    }
}