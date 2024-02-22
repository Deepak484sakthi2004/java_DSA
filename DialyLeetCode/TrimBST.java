package DialyLeetCode;
import java.util.LinkedList;
import java.util.Queue;
public class TrimBST {
    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int d)
        {this.val = d;}

        TreeNode(int d,TreeNode l,TreeNode r)
        {
            this.val = d;
            this.left = l;
            this.right = r;
        }
    }

    public static class Solution{
        public static TreeNode trimBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode cur = q.poll();

            if(cur.left!=null && (cur.left.val> high || cur.left.val < low))
            {
                cur.left = (cur.left.val<low)? cur.left.right:cur.left.left ;
            }
            if(cur.right!=null && (cur.right.val> high || cur.right.val < low))
            {
              cur.right = (cur.right.val<low)? cur.right.right:cur.right.left;
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
            return root;
        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
         root.right = new TreeNode(2);
        //    root.left = new TreeNode();

//         root.left.left = new TreeNode(0);
//         root.left.right = new TreeNode(4);
//         root.right.right = new TreeNode(11);
       TreeNode temp =  Solution.trimBST(root,2,4);
       bfs(temp);

    }
    public static void bfs(TreeNode root)
    {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q= new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode cur = q.poll();
            System.out.println(cur.val);
            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);

        }
    }

}
