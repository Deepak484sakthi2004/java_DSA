import java.util.Arrays;


// the given array it print the way the array gets splits

class mergeSort_ArrayDivideTree
{
    static class divideTree
    {
        int[] a;
        divideTree left;
        divideTree right;

        divideTree(int[] a)
        {
            this.a=a;
            this.left=null;
            this.right=null;
        }

    }
    public static void main(String[] args) {
        int[] a=new int[]{12,32,4,1,76,9,5};
    divideTree root=buildTree(a);

    printTree(root);

    }
    static divideTree buildTree(int[] a)
    {
        int n=a.length;

        if(n==1)
        {
            return new divideTree(a);
        }

        divideTree root=new divideTree(a);
        int middle=n/2;
        int[] left=Arrays.copyOfRange(a,0,middle);
        root.left=buildTree(left);

        int[] right=Arrays.copyOfRange(a,middle,n);
        root.right=buildTree(right);


    return root;
    }
    static void printTree(divideTree root)
    {
        if(root == null)
            return ;
        System.out.println(Arrays.toString(root.a));
        printTree(root.left);
        printTree(root.right);
    }

}
// OUTPUT :
//[12, 32, 4, 1, 76, 9, 5]
//        [12, 32, 4]
//        [12]
//        [32, 4]
//        [32]
//        [4]
//        [1, 76, 9, 5]
//        [1, 76]
//        [1]
//        [76]
//        [9, 5]
//        [9]
//        [5]
