package Daily.D0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2117 {
    static int SIZE;
    static int COST;
    static int[][] map;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            SIZE = Integer.parseInt(st.nextToken());
            COST = Integer.parseInt(st.nextToken());
            map = new int[SIZE][SIZE];

            for (int index_x = 0 ; index_x < SIZE; index_x++) {
                st = new StringTokenizer(br.readLine());
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    map[index_x][index_y] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append('#').append(t).append(' ').append('\n');
        }
        System.out.println(sb);
    }
}
