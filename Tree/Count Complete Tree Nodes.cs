/*
Url:-https://leetcode.com/problems/contiguous-array/

Given a complete binary tree, count the number of nodes.

Solution Approach:-Traversing.

*/
public class Solution {
    
    public int CountNodes(TreeNode root) {
       //add Code here.
    if(root!=null ){
     return 1+ CountNodes(root.left)+CountNodes(root.right);
        
    }
    return 0; 
    }
}