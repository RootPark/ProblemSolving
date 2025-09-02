package Daily.D0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Swea2819 {

    static int SIZE = 4;
    static int[][] arr;

    static int[] delta_x = { 1, -1, 0, 0 };
    static int[] delta_y = { 0, 0, 1, -1 };

    static HashSet<String> hashSet;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            arr = new int[SIZE][SIZE];
            hashSet = new HashSet<>();
            for (int index_x = 0; index_x < SIZE; index_x++) {
                st = new StringTokenizer(br.readLine());
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    arr[index_x][index_y] = Integer.parseInt(st.nextToken());
                }
            }

            for (int index_x = 0; index_x < SIZE; index_x++) {
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    move(index_x, index_y, 0, "" + arr[index_x][index_y]);
                }
            }

            sb.append("#").append(t).append(" ").append(hashSet.size()).append("\n");
        }
        System.out.println(sb);
    }

    public static void move(int x, int y, int depth, String str) {
        if (depth == 6) {
            hashSet.add(str);
            return;
        }

        for (int index = 0; index < delta_x.length; index++) {
            int new_x = x + delta_x[index];
            int new_y = y + delta_y[index];

            if (new_x >= 0 && new_y >= 0 && new_x < SIZE && new_y < SIZE) {
                move(new_x, new_y, depth + 1, str + arr[new_x][new_y]);
            }
        }
    }
}
