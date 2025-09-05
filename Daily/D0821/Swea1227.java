package Daily.D0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1227 {
    static int TEST_CASE = 10;
    static int[][] maze;
    static int SIZE = 100;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= TEST_CASE; t++) {
            int testCase = Integer.parseInt(br.readLine());
            maze = new int[100][100];

            for (int index_x = 0; index_x < SIZE; index_x++) {
                String line = br.readLine();
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    maze[index_x][index_y] = Integer.parseInt(line.substring(index_y, index_y));
                }
            }


            sb.append("#").append(testCase).append(" ").append("\n");
        }
    }
}
