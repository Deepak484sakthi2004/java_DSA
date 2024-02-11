package DialyLeetCode;
import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LargestValueEveryLevel {

   static class TreeNode
    {
        int val;
        TreeNode left,right;
        TreeNode() {}
        TreeNode(int val)
        {
            this.val=val;
        }
        TreeNode(int val,TreeNode l,TreeNode r)
        {
            this.val=val;
            this.left=l;
            this.right=r;
        }
    }

    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            if (root==null) return new ArrayList<>();

            List<List<Integer>> nodes=BFS(root);

//            for(int i=0;i<nodes.size() ;i++)
//            {
//                for(int j=0;j<nodes.get(i).size();j++)
//                {
//                    System.out.print(nodes.get(i).get(j)+" ");
//                }
//                System.out.println();
//            }

            return maxLevel(nodes);
        }
        public static List<List<Integer>> BFS(TreeNode root)
        {
            List<List<Integer>> level = new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty())
            {
                List<Integer> in=new ArrayList<>();
                int size=q.size();

                for(int i=0;i<size;i++)
                {
                    TreeNode node = q.poll();
                    in.add(node.val);
                    if(node.left!=null) {
                        q.offer(node.left);

                    }
                    if(node.right!=null)
                    {
                        q.offer(node.right);
                        //in.add(node.right.val);

                    }
                }
                level.add(in);
            }

            return level;
        }

        public static List<Integer> maxLevel(List<List<Integer>> a)
        {   List<Integer> res=new ArrayList<>();

            for(int i=0;i<a.size() ;i++)
            {
                res.add((Collections.max(a.get(i))));
            }
            return res;
        }

    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
         root.left = new TreeNode(3);
         root.right = new TreeNode(2);
         root.left.left = new TreeNode(5);
         root.left.right=new TreeNode(3);
         root.right.right = new TreeNode(9);
         root.right.right.right = new TreeNode(12);
         Solution s = new Solution();

         List<Integer> l  = s.largestValues(root);

         for(int i=0;i<l.size();i++)
         {
             System.out.println(l.get(i));
         }
    }

}
