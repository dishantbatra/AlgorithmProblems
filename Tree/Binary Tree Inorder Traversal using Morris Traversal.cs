/*
Url:-https://leetcode.com/problems/binary-tree-inorder-traversal/

Binary Tree Inorder Traversal.

Solution Approach:-Morris Traversal (Threaded Binary Tree).
*/

public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class MorrisTraversal
    {
        public static IList<int> InOrderTraversal(TreeNode root)
        {
            IList<int> list = new List<int>();
            var current = root;
            while (current != null)
            {
                //When there exist no left subtree
                if (current.left == null)
                {
                    list.Add(current.val);
                    current = current.right;
                }
                else
                {
                    //Get Inorder Predecessor
                    //In Order Predecessor is the node which will be printed before
                    //the current node when the tree is printed in inorder.
                    //Example:- {1,2,3,4} is inorder of the tree so inorder predecessor of 2 is node having value 1
                    var inOrderPredecessorNode = GetInorderPredecessor(current);
                    //If the current Predeccessor right is the current node it means is already printed.
                    //So we need to break the thread.
                    if (inOrderPredecessorNode.right != current)
                    {
                        inOrderPredecessorNode.right = null;
                        list.Add(current.val);
                        current = current.right;
                    }//Creating thread of the current node with in order predecessor.
                    else
                    {
                        inOrderPredecessorNode.right = current;
                        current = current.left;
                    }
                }
            }

            return list;
        }

        private static TreeNode GetInorderPredecessor(TreeNode current)
        {
            var inOrderPredecessorNode = current.left;
            while (inOrderPredecessorNode.right != null && inOrderPredecessorNode.right != current)
            {
                inOrderPredecessorNode = inOrderPredecessorNode.right;
            }

            return inOrderPredecessorNode;
        }
    }