package Daily.D0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea5215 {
    static int LIMIT;
    static int NUMBER_OF_INGREDIENT;
    static int[][] data;
    static int SCORE_INDEX = 0;
    static int CAL_INDEX = 1;
    static int[][] scoreByCal;

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            NUMBER_OF_INGREDIENT = Integer.parseInt(st.nextToken());
            LIMIT = Integer.parseInt(st.nextToken());

            data = new int[NUMBER_OF_INGREDIENT+1][2];
            scoreByCal = new int[NUMBER_OF_INGREDIENT+1][LIMIT+1];

            for (int indexOfIngredient = 1; indexOfIngredient <= NUMBER_OF_INGREDIENT; indexOfIngredient++) {
                st = new StringTokenizer(br.readLine());
                data[indexOfIngredient][SCORE_INDEX] = Integer.parseInt(st.nextToken());
                data[indexOfIngredient][CAL_INDEX] = Integer.parseInt(st.nextToken());
                scoreByCal[indexOfIngredient][data[indexOfIngredient][CAL_INDEX]] = data[indexOfIngredient][SCORE_INDEX];
            }

            for (int indexOfIngredient = 1; indexOfIngredient <= NUMBER_OF_INGREDIENT; indexOfIngredient++) {
                for (int calories = 1; calories <= LIMIT; calories++) {
                    if (data[indexOfIngredient][CAL_INDEX] > calories) {
                        scoreByCal[indexOfIngredient][calories] = scoreByCal[indexOfIngredient-1][calories];
                    }
                    else {
                        scoreByCal[indexOfIngredient][calories] = Math.max(scoreByCal[indexOfIngredient-1][calories], scoreByCal[indexOfIngredient-1][calories-data[indexOfIngredient][CAL_INDEX]] +data[indexOfIngredient][SCORE_INDEX]);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(scoreByCal[NUMBER_OF_INGREDIENT][LIMIT]).append("\n");        
        }

        System.out.println(sb);
    }
}