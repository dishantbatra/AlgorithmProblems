

/*
Url:-https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Lowest Common Ancestor of a Binary Tree.

Solution Approach:- Divide and Conquer.

*/
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x)
    {
        val = x;
    }
}
public class Solution
{
    private static TreeNode CommonNode = null;
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        CommonNode = root;
        SetCommonNode(root, p, q);
        return CommonNode;
    }

    public static bool SetCommonNode(TreeNode node, TreeNode n1, TreeNode n2)
    {
        var localIsTrue = false;
        if (node == null)
        {
            return false;
        }
        if (node == n1 || node == n2)
        {
            localIsTrue = true;
        }

        if (node.left == null && node.right == null)
        {
            return localIsTrue;
        }
        var leftSide = SetCommonNode(node.left, n1, n2);
        if (localIsTrue && leftSide)
        {
            CommonNode = node;
            return false;
        }
        var rightSide = SetCommonNode(node.right, n1, n2);
        if (localIsTrue && rightSide)
        {
            CommonNode = node;
            return false;
        }
        if (leftSide == true && rightSide == true)
        {
            CommonNode = node;
        }
        return leftSide || rightSide || localIsTrue;
    }
}