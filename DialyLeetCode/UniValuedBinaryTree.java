package DialyLeetCode;

public class UniValuedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
        }
    }

    public static class Solution {
        public static boolean isUnivalTree(TreeNode root) {
            return rec(root, root.val);
        }

        public static boolean rec(TreeNode root, int data) {
            if (root == null) {
                return true;
            }

            if (root.val != data) {
                return false;
            }

            // Add null checks before accessing val fields
            boolean leftUnival = root.left == null || rec(root.left, data);
            boolean rightUnival = root.right == null || rec(root.right, data);

            return leftUnival && rightUnival;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(2);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(2);

            boolean result = isUnivalTree(root);
            System.out.println(result);
        }
    }
}
