package Daily.D0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2819 {

    static int SIZE = 4;
    static int[][] arr;
    static int[] delta_x = {-1, 0, 1, 0}; // 좌 상 우 하
    static int[] delta_y = {0, 1, 0, -1}; // 좌 상 우 하

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            arr = new int[SIZE][SIZE];
            for (int index_x = 0; index_x < SIZE; index_x++) {
                st = new StringTokenizer(br.readLine());
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    arr[index_x][index_y] = Integer.parseInt(st.nextToken());
                }
            }


        }
    }
}
