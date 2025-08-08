package Daily.D0807;

import java.io.*;
import java.util.StringTokenizer;

// swea
// 5215

public class Swea5215 {

    static int numOfIngredients;
    static int limitCal;
    static int numOfComb;
    static int[][] data;
    static int[][] choice;
    static int maxPoint = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            numOfIngredients = Integer.parseInt(st.nextToken());
            limitCal = Integer.parseInt(st.nextToken());
            data = new int[numOfIngredients][2];
            maxPoint = 0;

            for (int numOfIngredient = 0; numOfIngredient < numOfIngredients; numOfIngredient++) {
                st = new StringTokenizer(br.readLine());
                data[numOfIngredient][0] = Integer.parseInt(st.nextToken());
                data[numOfIngredient][1] = Integer.parseInt(st.nextToken());
            }
            for (numOfComb = 1; numOfComb <= numOfIngredients; numOfComb++) {
                choice = new int[numOfComb][2];
                combination(0, 0);
            }

            sb.append("#").append(t).append(" ").append(maxPoint).append("\n");
        }
        System.out.println(sb);

    }

    public static void combination(int elementIndex, int selectIndex) {
        if (selectIndex == numOfComb) {
            int sumOfCal = 0;
            int sumOfPoint = 0;
            for (int i = 0; i < choice.length; i++) {
                sumOfCal += choice[i][1];
                sumOfPoint += choice[i][0];
            }
            if (sumOfCal <= limitCal) {
                if (sumOfPoint > maxPoint) {
                    maxPoint = sumOfPoint;
                }
            }
            return;
        }

        if (elementIndex == numOfIngredients) {
            return;
        }

        choice[selectIndex][0] = data[elementIndex][0];
        choice[selectIndex][1] = data[elementIndex][1];

        combination(elementIndex + 1, selectIndex + 1);

        choice[selectIndex][0] = 0;
        choice[selectIndex][1] = 0;

        combination(elementIndex + 1, selectIndex);
    }
}
