package Daily.D0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1251 {
    static int ELEMENT_COUNT;
    static int[][] elementsCoordinates;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            ELEMENT_COUNT = Integer.parseInt(br.readLine());

            elementsCoordinates = new int[ELEMENT_COUNT][2];

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < ELEMENT_COUNT; index++) {
                elementsCoordinates[index][0] = Integer.parseInt(st.nextToken()); // x coordinates
            }

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < ELEMENT_COUNT; index++) {
                elementsCoordinates[index][1] = Integer.parseInt(st.nextToken()); // y coordinates
            }

        }
    }
}
