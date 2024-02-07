import java.util.*;
class web {




        static class btree
        {
            int data;
            btree left;
            btree right;

            btree(int d)
            {
                this.data=d;
            }
        }

        // INSERTION IN BINARY SEARCH TREE!!

        public static void main(String[] args)
        {
            web m=new web();
            btree root=null;

            Scanner z=new Scanner(System.in);

            boolean check=true;
            while(check)
            {
                int ele=z.nextInt();
                if(ele!=-1)
                {
                    root=m.btree_insert(ele,root);
                }
                else
                {
                    check=!check;
                }

            }
            System.out.println(m.sum(root));

        }
        btree btree_insert(int x ,btree root) {
            // btree node = new btree(x);

            // if root is null, create a node and return it!
            if (root == null) {
                btree curr=new btree(x);
                return curr;

            }

            // if the input is less, insert in the left
            if(root.data >= x)
            {
                root.left=btree_insert(x,root.left);
            }
            //
            else {
                root.right=btree_insert(x,root.right);
            }

            return root;

        }
        int sum(btree root) {


            if(root==null)
                return 0;

            int leftsum=sum(root.left);
            int rightsum=sum(root.right);

            return root.data+leftsum+rightsum;
        }











}
    //

   // public static void main(String[] args) {
//            Queue<Integer> q=new LinkedList<>();
//            Scanner z=new Scanner(System.in);
//            int o=z.nextInt();
//
//            for(int i=0;i<o;i++)
//                q.offer(z.nextInt());
//
//
//        int minval=Integer.MAX_VALUE;
//       // int minpos=0;
//        for(int i=0;i<o;i++)
//        {
//            int ele=q.poll();
//            if(minval>ele)
//            {
//                minval=ele;
//            }
//            q.offer(ele);
//        }
//
//
//
//    }