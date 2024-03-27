package SKILLRACK.tests;
import java.util.*;
import java.util.*;
//5 3 0 1 2 5 2 3 0 3 4

public class NumberOfBishopAttack {
    public static void main(String[] args) {
        int n = 5;
        Scanner z = new Scanner(System.in);
        int count = z.nextInt(); // Number of bishops
        ArrayList<Integer> sumList = new ArrayList<>();
        ArrayList<Integer> diffList = new ArrayList<>();
        int attacks = 0;

        for (int i = 0; i < count; i++) {
            System.out.println("enter x");
            int x = z.nextInt();
            System.out.println("enter y");
            int y = z.nextInt();

            int sum = x + y;
            int diff = Math.abs(x - y);
            if (sumList.contains(sum) || diffList.contains(diff)) {
                attacks ++;
                System.out.println("attack found by" + x + " " + y);
            }
                sumList.add(sum);
                diffList.add(diff);
            }

        System.out.println("Number of attacks between bishops: " + attacks);
    }
}
