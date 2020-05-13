  /*
Url:-https://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/

uestion: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property. You can only increment data values in any node (You cannot change the structure of the tree and cannot decrement the value of any node).

For example, the below tree doesn’t hold the children sum property, convert it to a tree that holds the property.

             50
           /     \     
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30
Solution Approach:- POST ORDER,Increment Helper Function
*/
  
  class TreeNode
    {
             public int val;
             public TreeNode left;
                 public TreeNode right;
                 public TreeNode(int x) { this.val = x; this.left = this.right = null; }
     }
    class Solution
    {
        public static TreeNode solve(TreeNode A)
        {
            if (A == null)
            {
                return null;
            }
            int left = 0;
            int right = 0;
            if (A.left == null && A.right == null) return A;
            if (A.left != null)
            {
                solve(A.left);
                left = A.left.val;
            }
            if (A.right != null)
            {
                solve(A.right);
                right = A.right.val;
            }

            if (A.val < left + right)
            {
                A.val = left + right;
            }
            else
            {
                int incrementValue = A.val-left + right;
                if (A.left != null)
                {
                    IncrementSubTree(A.left, incrementValue);
                }
                else if (A.right != null)
                {
                    IncrementSubTree(A.right, incrementValue);
                }
            }
            return A;
        }
        private static void IncrementSubTree(TreeNode A, int incrementValue)
        {
            if (A == null)
            {
                return;
            }
            if (A.left != null)
            {
                IncrementSubTree(A.left, incrementValue);
            }
            else
            {
                IncrementSubTree(A.right, incrementValue);
            }
            A.val += incrementValue;
        }
    }