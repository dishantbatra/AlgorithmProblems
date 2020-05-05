
/*
Url:-https://www.geeksforgeeks.org/diameter-of-a-binary-tree/

Diameter of a Binary Tree.

Solution Approach:- Greedy.

*/

namespace ConsoleApp3
{
    public class Solution
    {
        public class Node
        {
            public int val;
            public Node left;
            public Node right;

            public Node(int val = 0, Node left = null, Node right = null)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        public int DiameterOfBinaryTree(Node root)
        {
            var diameter = 1;
            while (root != null)
            {
                if (root.left != null && root.right != null)
                {
                    int left = getHeightOfTree(root.left) + 1;
                    int right = getHeightOfTree(root.right) + 1;
                    if (diameter < left + right + 1)
                    {
                        diameter = left + right + 1;
                    }
                    if (left > right)
                    {
                        root = root.left;
                    }
                    else
                    {
                        root = root.right;
                    }
                }
                else if (root.left != null)
                {
                    int left = getHeightOfTree(root.left) + 1;
                    root = root.left;
                    if (diameter < (left + 1))
                    {
                        diameter = left + 1;
                    }
                }
                else if (root.right != null)
                {
                    int right = getHeightOfTree(root.right) + 1;
                    root = root.right;
                    if (diameter < (right + 1))
                    {
                        diameter = right + 1;
                    }
                }
                else
                {
                    root = null;
                }
            }

            return diameter;

        }

        int getHeightOfTree(Node root)
        {
            int left = root.left != null ? 1 + getHeightOfTree(root.left) : 0;
            int right = root.right != null ? 1 + getHeightOfTree(root.right) : 0;
            return left > right ? left : right;
        }
    }
}
