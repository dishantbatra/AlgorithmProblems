/*
Url:-https://leetcode.com/problems/average-of-levels-in-binary-tree/

 Average of Levels in Binary Tree

Solution Approach:- Level Order Traversal.
*/

using System.Collections.Generic;

namespace ConsoleApp3
{
    public class Node
    {
        public Node left;
        public Node right;
        public int val;

        public Node(int val = 0, Node left = null, Node right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class AverageTree
    {
        public IList<double> AverageOfLevels(TreeNode root)
        {
            var list1 = new List<TreeNode>();
            var list2 = new List<TreeNode>();
            var averageList = new List<double>();
            list1.Add(root);

            while (list1.Count != 0 || list2.Count != 0)
            {
                double sum = 0;
                switch (list1.Count)
                {
                    case 0 when list2.Count == 0:
                        continue;
                    case 0:
                        list2.ForEach(x =>
                        {
                            sum = x.val + sum;
                            if (x.left != null) list1.Add(x.left);

                            if (x.right != null) list1.Add(x.right);
                        });
                        averageList.Add(sum / list2.Count);
                        list2 = new List<TreeNode>();
                        break;
                    default:
                        list1.ForEach(x =>
                        {
                            sum = x.val + sum;
                            if (x.left != null) list2.Add(x.left);

                            if (x.right != null) list2.Add(x.right);
                        });
                        averageList.Add(sum / list1.Count);
                        list1 = new List<TreeNode>();
                        break;
                }
            }

            return averageList;
        }
    }
}