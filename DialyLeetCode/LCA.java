package DialyLeetCode;

import com.sun.source.tree.Tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LCA {
    public static class TreeNode{
        int val;
        TreeNode left,right;

        TreeNode(int d)
        {
            this.val=d;
        }
    }
    public static class Solution{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root==null) return root;

            if(root == p || root == q ) return root;

            TreeNode left_rec = lowestCommonAncestor(root.left,p,q);
            TreeNode right_rec= lowestCommonAncestor(root.right,p,q);

//            if(left_rec!=null) return
            if (left_rec != null && right_rec != null)
                return root;

            return (left_rec != null) ? left_rec : right_rec;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
        root.right.left = new TreeNode(12);

    }
}
