package DialyLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {
    class Solution {
        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int d) {
                this.val = d;
            }
        }

        public static TreeNode sortedArrayToBST(int[] nums) {
        return divide(nums,0,nums.length-1);
        }

        public static TreeNode divide(int[] a, int low, int high) {
            if (low <= high) {
                int mid = (low + high) / 2;
                TreeNode root = new TreeNode(a[mid]);
                root.left = divide(a, low, mid-1);
                root.right = divide(a, mid+1, high);
                return root;
            }
            return null;
        }
    }

        public static void bfs(Solution.TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<Solution.TreeNode> q = new LinkedList<>();

            q.offer(root);

            while (!q.isEmpty()) {
                Solution.TreeNode cur = q.poll();
                System.out.println(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);

            }
        }

        public static void main(String[] args) {

           bfs(Solution.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9}));
        }

    }


