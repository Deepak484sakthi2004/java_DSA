//package C:\Users\deepa\IdeaProjects\Array1\src\mergeSort_ArrayDividegenericTree;

import java.util.Arrays;

public class mergeSort_ArrayDividegenericTree {

    static class divideTree<T> {
        T[] value;
        divideTree<T> left;
        divideTree<T> right;

         divideTree(T[] a)
        {
            this.value=a;
            this.left=null;
            this.right=null;
        }
    }

//    public static void main(String[] args) {
//        String[] str=new String[]{"Hello","I","am","deepaksakthi","how","are","you"};
//    divideTree<String> root=buildTree(str);
//
//    printTree(root);
//
//
//    }
    static <T> divideTree<T> buildTree(T[] a)
    {
        int n=a.length;
        if(n==1) return  new divideTree<>(a);

        int middle=n/2;

        divideTree<T> root=new divideTree(a);
        T[] left=Arrays.copyOfRange(a,0,middle);
        root.left=buildTree(left);

        T[] right=Arrays.copyOfRange(a,middle,n);
        root.right=buildTree(right);

        return root;
    }

    static <T> void printTree(divideTree<T> a)
    {
        if(a==null) return ;

        System.out.println(Arrays.toString(a.value));
        printTree(a.left);
        printTree(a.right);
    }

}
