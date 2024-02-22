package DialyLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtoGreaterTree {


    static class Solution {
        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int d) {
                this.val = d;
            }
        }

        public static TreeNode convertBST(TreeNode root) {
            int x =rec(root, 0);
            return root;
        }

        public static  int rec(TreeNode root, int data) {
            if (root == null) return data;

//            if (root.left == null && root.right == null) {
//                //root.val += data;
//                data = root.val;
//            }
//            if (root.right == null) {
//                root.val += data;
//                data = root.val;
//            }

           int right_sum =  rec(root.right, data);
            root.val += right_sum;

            int left_sum = rec(root.left, root.val);
            return left_sum;


        }

        public static void bfs(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();

            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                System.out.println(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);

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

           convertBST(root);
           bfs(root);

        }
    }
}
