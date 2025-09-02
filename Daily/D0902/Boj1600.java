package Daily.D0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1600 {
    static int MOVE_NUM;
    static int WIDTH;
    static int HEIGHT;
    static int[][] board;
    static int[] delta_x = { 0, 0, -1, 1 };
    static int[] delta_y = { 1, -1, 0, 0 };

    static int[] horse_x = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] horse_y = { 1, 2, 2, 1, -1, -2, -2, -1 };

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MOVE_NUM = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        WIDTH = Integer.parseInt(st.nextToken());
        HEIGHT = Integer.parseInt(st.nextToken());
        board = new int[HEIGHT][WIDTH];

        for (int index_x = 0; index_x < HEIGHT; index_x++) {
            st = new StringTokenizer(br.readLine());
            for (int index_y = 0; index_y < WIDTH; index_y++) {
                board[index_x][index_y] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
