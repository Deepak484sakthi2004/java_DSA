package BinaryTree;
import java.lang.Math;
import com.sun.source.tree.Tree;

// problem link
// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class minimumDepthBTree
{
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        root.val=2;
// [2,null,3,null,4,null,5,null,6]
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(4);
        root.right.right=new TreeNode(5);
        root.right.right.right= new TreeNode(6);

        minimumDepthBTree mdt=new minimumDepthBTree();
        System.out.println("the minimumDepthBTree is:"+mdt.minDepth(root));
    }

    public int minDepth(TreeNode root) {
    if(root==null) return 0;
        System.out.println(root.val);
    return 1+Math.min(minDepth(root.left),minDepth(root.right));

    }
}