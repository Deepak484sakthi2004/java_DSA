package SKILLRACK.tests;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTime {

    public static void main(String[] args) {
        String[][] fruits = new String[][]
                {
                        {"RA", "A", "B", "RB"},
                        {"B", "A", "A", "B"},
                        {"A", "B", "B", "B"}
                };

        int nRow = fruits.length;
        int nCol = fruits[0].length;

        int freshCount = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (fruits[i][j].equals("A") || fruits[i][j].equals("B")) {
                    freshCount++;
                } else {
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        if (freshCount == 0) {
            System.out.println("0");
            return;
        }

        int time = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int t = p.t;

            time = Math.max(time, t);

            int[] d = {0, 1, 0, -1, 0};
            for (int dir = 0; dir < 4; dir++) {
                int xi = x + d[dir];
                int yi = y + d[dir + 1];

                if (xi >= 0 && yi >= 0 && xi < nRow && yi < nCol &&
                        (!fruits[xi][yi].equals("RA") && !fruits[xi][yi].equals("RB"))) {

                    if (fruits[xi][yi].equals("A")) {
                        fruits[xi][yi] = "RA";
                        q.offer(new Pair(xi, yi, t + 1)); // Adding newly rotten fruit to queue
                    }
                    if (fruits[xi][yi].equals("B")) {
                        fruits[xi][yi] = "RB";
                        q.offer(new Pair(xi, yi, t + 2)); // Adding newly rotten fruit to queue
                    }
                }
            }
        }

        System.out.println(time);
    }

    static class Pair {
        int x, y, t;

        Pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
