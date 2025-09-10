package Daily.D0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1247 {
    static int numberOfCustomers;
    static int[][] position;
    static boolean[] visited;
    static int X = 0;
    static int Y = 1;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int minDistance;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            numberOfCustomers = Integer.parseInt(br.readLine());
            position = new int[numberOfCustomers][2];
            visited = new boolean[numberOfCustomers];
            minDistance = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            for (int customerIndex = 0; customerIndex < numberOfCustomers; customerIndex++) {
                position[customerIndex][X] = Integer.parseInt(st.nextToken());
                position[customerIndex][Y] = Integer.parseInt(st.nextToken());
            }

            dfs(0, startX, startY, 0);
            sb.append('#').append(t).append(' ').append(minDistance).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int positionCount, int preX, int preY, int sum) {
        if (sum >= minDistance) {
            return;
        }

        if (positionCount == numberOfCustomers) {
            minDistance = Math.min(minDistance, sum + getDistance(preX, preY, endX, endY));
            return;
        }

        for (int customerIndex = 0; customerIndex < numberOfCustomers; customerIndex++) {
            if (visited[customerIndex]) {
                continue;
            }

            visited[customerIndex] = true;
            dfs(positionCount + 1, position[customerIndex][X], position[customerIndex][Y],
                    sum + getDistance(preX, preY, position[customerIndex][X], position[customerIndex][Y]));
            visited[customerIndex] = false;
        }
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
