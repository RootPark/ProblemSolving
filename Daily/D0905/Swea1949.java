package Daily.D0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1949 {
    static int SIZE;
    static int MAX_DEPTH_DELETE;
    static int MAX_HEIGHT;
    static int answer;
    static int[][] mountain;
    static boolean[][] visited;

    static int[] delta_x = { 1, -1, 0, 0 };
    static int[] delta_y = { 0, 0, -1, 1 };

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());

            SIZE = Integer.parseInt(st.nextToken());
            MAX_DEPTH_DELETE = Integer.parseInt(st.nextToken());
            MAX_HEIGHT = Integer.MIN_VALUE;

            mountain = new int[SIZE][SIZE];
            visited = new boolean[SIZE][SIZE];
            answer = -1;

            for (int index_x = 0; index_x < SIZE; index_x++) {
                st = new StringTokenizer(br.readLine());
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    mountain[index_x][index_y] = Integer.parseInt(st.nextToken());
                    MAX_HEIGHT = Math.max(mountain[index_x][index_y], MAX_HEIGHT);
                }
            }

            for (int index_x = 0; index_x < SIZE; index_x++) {
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    if (mountain[index_x][index_y] != MAX_HEIGHT) {
                        continue;
                    }
                    visited[index_x][index_y] = true;
                    dfs(index_x, index_y, 1, mountain[index_x][index_y], MAX_DEPTH_DELETE);
                    visited[index_x][index_y] = false;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y, int length, int height, int deletion) {
        answer = Math.max(length, answer);

        for (int index = 0; index < delta_x.length; index++) {
            int current_x = x + delta_x[index];
            int current_y = y + delta_y[index];

            if (!(current_x >= 0 && current_x < SIZE && current_y >= 0 && current_y < SIZE) || visited[current_x][current_y]) {
                continue;
            }

            if (deletion == 0) {
                if (mountain[current_x][current_y] < height) {
                    visited[current_x][current_y] = true;
                    dfs(current_x, current_y, length + 1, mountain[current_x][current_y], deletion);
                    visited[current_x][current_y] = false;
                }
            } else {
                if (mountain[current_x][current_y] < height) {
                    visited[current_x][current_y] = true;
                    dfs(current_x, current_y, length + 1, mountain[current_x][current_y], deletion);
                    visited[current_x][current_y] = false;
                } else if ((mountain[current_x][current_y] - deletion) < height) {
                    visited[current_x][current_y] = true;
                    dfs(current_x, current_y, length + 1, height - 1, 0);
                    visited[current_x][current_y] = false;
                }
            }

        }
    }
}
