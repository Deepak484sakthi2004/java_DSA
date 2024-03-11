package DialyLeetCode;
// 1382. Balance a Binary Search Tree
// https://leetcode.com/problems/balance-a-binary-search-tree/description/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BalanceBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int d) {
            this.val = d;
        }
    }
    public static class Solution
    {
        public static TreeNode balanceBST(TreeNode root) {
            // convert it into a sorted array
            // then sorted array to BST
            ArrayList<Integer> list = new ArrayList<>();
            sortedArray(root,list);
            System.out.println(list.toString());
            return BST(list); // inorder+ArrayList

        }
            public static void sortedArray(TreeNode root,ArrayList<Integer> list)
            {
                if(root == null) return ;
                sortedArray(root.left,list);
                list.add(root.val);
                sortedArray(root.right,list);
            }
            public static TreeNode BST( ArrayList<Integer> list)
            {

                TreeNode root = BSTform(list,0,list.size()-1);
                return root;
            }
            public static TreeNode  BSTform(ArrayList<Integer> list,int low,int high)
            {
                if(low<=high)
                {
                    int mid = (low+high)/2;
                    TreeNode root = new TreeNode(list.get(mid));
                    root.left = BSTform(list,low,mid-1);
                    root.right = BSTform(list,mid+1,high);
                    return root;
                }
                return null;
            }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(10);
        bfs(Solution.balanceBST(root));

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
}
