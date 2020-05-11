/*
Url:-https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Solution Approach:- BFS,HASH MAP
*/

 public class TreeNode {
         public int val;
        public TreeNode left;
        public TreeNode right;
         public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


     public class Solution {
        public TreeNode SortedArrayToBST(int[] nums) {
            return GetNode(nums,0,nums.Length-1);
        }
        
        private TreeNode GetNode(int[]nums,int start,int end){
            if(start>end)return null;
            int middle = (start+end)/2;
             var node =new TreeNode(nums[middle]);
            node.left = GetNode(nums,start,middle-1);
            node.right=GetNode(nums,middle+1,end);
            return node;
        }
    }