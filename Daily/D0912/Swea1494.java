package Daily.D0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1494 {
    static int SIZE;
    static int NUM_OF_VACTORS;
    static long[][] points;
    static boolean[] selected;
    static long sumOfX, sumOfY;
    static long min;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            SIZE = Integer.parseInt(br.readLine());
            NUM_OF_VACTORS = SIZE / 2;
            min = Long.MAX_VALUE;
            points = new long[SIZE][2];
            sumOfX = 0;
            sumOfY = 0;

            for (int pointIndex = 0; pointIndex < SIZE; pointIndex++) {
                st = new StringTokenizer(br.readLine());
                points[pointIndex][0] = Long.parseLong(st.nextToken());
                points[pointIndex][1] = Long.parseLong(st.nextToken());

                sumOfX += points[pointIndex][0];
                sumOfY += points[pointIndex][1];
            }
            find(0, 0, 0, 0);

            sb.append('#').append(t).append(' ').append(min).append('\n');
        }
        System.out.println(sb);
    }

    public static void find(int index, int selectedCount, long sum_x, long sum_y) {
        if (index - selectedCount > NUM_OF_VACTORS) {
            return;
        }

        if (index == SIZE) {
            if (selectedCount == NUM_OF_VACTORS) {
                long deltaX = sumOfX - (2 * sum_x);
                long deltaY = sumOfY - (2 * sum_y);
                long result = deltaX * deltaX + deltaY * deltaY;
                min = Math.min(min, result);
            }
            return;
        }

        find(index + 1, selectedCount + 1, sum_x + points[index][0], sum_y + points[index][1]);
        find(index+1, selectedCount, sum_x, sum_y);
    }
}
