
/*
Url:-https://www.geeksforgeeks.org/diameter-of-a-binary-tree/

Diameter of a Binary Tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 

Solution Approach:- Bottom Up Tree Traversing.
Time Completxity: O(n) Space Complexity: O(n) stack
*/

namespace ConsoleApp3
{
    public class Solution {
    public static int diameter=0;
    public int DiameterOfBinaryTree(TreeNode root) {
        diameter=0;
        if(root!=null&&(root.left!=null||root.right!=null)){
            GetHeight(root);
        }
        return diameter;
    }
    public int GetHeight(TreeNode root){
        if(root.left!=null && root.right!=null){
            int left =GetHeight(root.left);
            int right =GetHeight(root.right);
            if(diameter<left+right){
                diameter=left+right;
            }
            return Math.Max(left,right)+1;
        }else if(root.left!=null){
             int left =GetHeight(root.left);
              if(diameter<left){
                diameter=left;
            }
            return left+1;
        }else if(root.right!=null){
             int right =GetHeight(root.right);
              if(diameter<right){
                diameter=right;
            }
            return right+1;
        }else{
            return 1;
        }
    }
}
}
