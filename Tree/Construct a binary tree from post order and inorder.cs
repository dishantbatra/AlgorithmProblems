/*
Url:-https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Construct Binary Tree from Inorder and Postorder Traversal.

Solution Approach:-Hash Based.
Traversing the post order array from the end  and constructing right subtree first then left.Element picked from act as root element which divide tree into two parts.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

 
public class Solution {
    private static int _rootIndex = 0;
    public TreeNode BuildTree(int[] inOrder, int[] postOrder) {
         Dictionary<int, int> inOrderValues = new Dictionary<int, int>();
            for (int i = 0; i < inOrder.Length; i++)
            {
                inOrderValues.Add(inOrder[i], i);
            }
            _rootIndex = postOrder.Length - 1;
            return ConstructTree(inOrder, postOrder,0, inOrder.Length - 1, inOrderValues);
    }
    
    public static TreeNode ConstructTree(int[] inOrder, int[] postOrder,int startIndex,int endIndex, Dictionary<int, int> inOrderValues)
        {
             if (startIndex > endIndex)
            {
                return null;
            }

            var node= new TreeNode(postOrder[_rootIndex]);
            int rootIndexOnInorder = inOrderValues[node.val];
            int leftSubTreeEndIndex = rootIndexOnInorder - 1;
            _rootIndex--;
            if (rootIndexOnInorder + 1 <= endIndex)
            {

                node.right = ConstructTree(inOrder, postOrder, rootIndexOnInorder + 1,endIndex, inOrderValues);
            }

            if (startIndex <= rootIndexOnInorder - 1)
            {
                node.left = ConstructTree(inOrder, postOrder, startIndex, leftSubTreeEndIndex, inOrderValues);
            }

            return node;

        }
}