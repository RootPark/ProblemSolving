package Daily.D0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2115 {
    static int SIZE;
    static int NUMBER_OF_HONEY;
    static int AMOUNT_OF_HONEY;
    static int answer;
    static int[][] honey;
    static int[][] profit;

    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            answer = 0;

            st = new StringTokenizer(br.readLine());
            SIZE = Integer.parseInt(st.nextToken());

            NUMBER_OF_HONEY = Integer.parseInt(st.nextToken());
            AMOUNT_OF_HONEY = Integer.parseInt(st.nextToken());

            init_honey();
            find_max_position();

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void init_honey() throws IOException {
        honey = new int[SIZE][SIZE];
        profit = new int[SIZE][SIZE];

        for (int index_x = 0; index_x < SIZE; index_x++) {
            st = new StringTokenizer(br.readLine());
            for (int index_y = 0; index_y < SIZE; index_y++) {
                honey[index_x][index_y] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void find_max_position() {

        find_max_profit();
        for (int index_x = 0; index_x < SIZE; index_x++) {
            for (int index_y = 0; index_y <= SIZE - NUMBER_OF_HONEY; index_y++) {
                combination(index_x, index_y + NUMBER_OF_HONEY, 1, profit[index_x][index_y]);
            }
        }
    }

    public static void combination(int x, int y, int count, int sum) {
        if (count == 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int index_x = x; index_x < SIZE; index_x++) {
            for (int index_y = y; index_y <= SIZE - NUMBER_OF_HONEY; index_y++) {
                combination(index_x, index_y, count + 1, sum + profit[index_x][index_y]);
            }
            y = 0;
        }
    }

    public static void find_max_profit() {
        for (int index_x = 0; index_x < SIZE; index_x++) {
            for (int index_y = 0; index_y <= SIZE - NUMBER_OF_HONEY; index_y++) {
                subset(index_x, index_y, 0, 0, 0);
            }
        }
    }

    public static void subset(int x, int y, int count, int sum, int totalSum) {
        if (sum > AMOUNT_OF_HONEY) {
            return;
        }

        if (count == NUMBER_OF_HONEY) {
            profit[x][y - NUMBER_OF_HONEY] = Math.max(profit[x][y - NUMBER_OF_HONEY], totalSum);
            return;
        }

        subset(x, y + 1, count + 1, sum + honey[x][y], totalSum + (honey[x][y] * honey[x][y]));
        subset(x, y + 1, count + 1, sum, totalSum);
    }
}
