package Daily.D0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149 {
    static int NUMBER;
    static int RED = 0;
    static int GREEN = 1;
    static int BLUE = 2;
    static int[] red;
    static int[] green;
    static int[] blue;
    static int[][] sum;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        red = new int[NUMBER];
        green = new int[NUMBER];
        blue = new int[NUMBER];
        sum = new int[NUMBER][3];

        for (int index = 0; index < NUMBER; index++) {
            st = new StringTokenizer(br.readLine());
            red[index] = Integer.parseInt(st.nextToken());
            green[index] = Integer.parseInt(st.nextToken());
            blue[index] = Integer.parseInt(st.nextToken());
        }

        sum[0][RED] = red[0];
        sum[0][GREEN] = green[0];
        sum[0][BLUE] = blue[0];

        System.out.println(
                Math.min(choose(NUMBER - 1, RED), Math.min(choose(NUMBER - 1, GREEN), choose(NUMBER - 1, BLUE))));
    }

    public static int choose(int index, int color) {
        if (sum[index][color] == 0) {
            if (color == RED) {
                sum[index][RED] = Math.min(choose(index - 1, GREEN), choose(index - 1, BLUE)) + red[index];
            }

            if (color == GREEN) {
                sum[index][GREEN] = Math.min(choose(index - 1, RED), choose(index - 1, BLUE)) + green[index];
            }

            if (color == BLUE) {
                sum[index][BLUE] = Math.min(choose(index - 1, RED), choose(index - 1, GREEN)) + blue[index];
            }
        }

        return sum[index][color];
    }
}
