package Striver.Interview;
import java.util.ArrayList;

public class MinPrimesToReachTheTarget {

    private static void findFirstNprimes(ArrayList<Integer> list, int n) {
        if (n <= 1) return;
        int number = 2;
        while (n > 0) {
            if (isPrime(number)) {
                list.add(number);
                n--;
            }
            number++;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int num = 2; num * num <= n; num++) {
            if (n % num == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int target = 11;
        int n = 2;
        ArrayList<Integer> list = new ArrayList<>();
        findFirstNprimes(list, n);
        System.out.println(list);
        int out = getMinCountsToReachTarget(list, target, 0);
        System.out.println(out);
    }

    private static int getMinCountsToReachTarget(ArrayList<Integer> list, int target, int idx) {
        if (target ==0) return 0;
        if (target < 0 || idx == list.size()) return -1;

        int pick = getMinCountsToReachTarget(list, target - list.get(idx), idx);
        int notPick = getMinCountsToReachTarget(list, target, idx + 1);

        if (pick == -1) return notPick;
        if (notPick == -1) return pick+1;

        return Math.min(notPick, pick+1);
    }
}
