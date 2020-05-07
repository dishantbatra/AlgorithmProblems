/*
Url:-https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

You are given a binary tree for which you have to print its vertical order traversal. your task is to complete the function verticalOrder which takes one argument the root of the binary tree and prints the node of the binary tree in vertical order as shown below.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal.

Solution Approach:- BFS,HASH MAP
*/

public class Node
    {
        public int data;
        public Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public class SumTree
    {
        public static int Sum = 0; // It is used to track the sum of current node  left Subtree or right Subtree.
        bool IsSumTree(Node node)
        {
            var leftSubtreeSum = 0;
            var rightSubtreeSum = 0;
            Sum = 0;
            if (node.left == null && node.right == null) //Leaf Node
            {
                Sum = node.data;
                return true;
            }

            if (node.left != null)
            {
                var leftSumValid = IsSumTree(node.left);
                if (!leftSumValid)
                {
                    return false;
                }
            }

            leftSubtreeSum = Sum; //Storing left tree sum
            Sum = 0; // Setting it to zero to get right subtree sum
            if (node.right != null)
            {
                var rightSumValid = IsSumTree(node.right);
                if (!rightSumValid)
                {
                    return false;
                }
            }

            rightSubtreeSum = Sum;
            if (leftSubtreeSum + rightSubtreeSum != node.data)
                return false;

            Sum = leftSubtreeSum + rightSubtreeSum + node.data;
            return true;
        }
    }